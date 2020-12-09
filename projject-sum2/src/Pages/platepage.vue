<template>
  <div id="plate">
    <div class="banner"></div>
    <div class="sub-banner">
      <div class="top">
        <div class="pic">
          <img
            src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg"
            alt=""
            srcset=""
          />
        </div>
        <div class="add">
          <div class="add-post" @click="visible = true">
            {{ addPost }}
          </div>
          <el-dialog :visible.sync="visible">
            <addPoster
              :token="realToken"
              :sectionId="realSectionId"
            ></addPoster>
          </el-dialog>
        </div>
        <div class="sectionFollow">
          <el-popover
            placement="right"
            title="你关注了吗"
            width="300"
            trigger="hover"
            content="当你想要在当前板块发帖时，请注意你是否已经关注该板块，没有关注的话是不能发帖的哦"
          >
            <el-button
              slot="reference"
              type="primary"
              @click="doFollow"
              plain
              round
              :disabled="isUse"
              >{{ situationFollow }}</el-button
            >
          </el-popover>
        </div>
        <el-button type="primary" v-if="showAdminButton" @click="toAdmin" style="margin-left: 20px;">管理</el-button>
      </div>
      <div class="register">
        <regist></regist>
      </div>
    </div>
    <div class="page">
      <div class="area">
        <poster
          v-for="section in sections"
          :key="section.sectionPostId"
          :postcount="section.sectionPostFloor"
          :posttitle="section.sectionPostName"
          :postauthor="section.user.userName"
          :posttime="section.sectionPostTime"
          @click.native="toTie(section.sectionPostId, section.sectionPostName)"
        ></poster>
      </div>
      <div class="msg">
        <plateInfo
          :masterInfo="info.sectionName"
          :ruleInfo="info.sectionIntroduce"
        ></plateInfo>
      </div>
    </div>
  </div>
</template>

<script>
import regist from "@/components/regist";
import poster from "@/components/post";
import plateInfo from "@/components/plateInfo";
import addPoster from "@/components/addPoster";

export default {
  name: "plate",
  data() {
    return {
      showAdminButton:false,
      addPost: "发帖",
      sections: [],
      info: {},
      visible: false,
      realToken: localStorage.getItem("token"),
      situationFollow: "未关注",
      isUse: false,
      sectionList: [],
      realSectionId: {
        type: Number,
      },
    };
  },
  components: {
    regist: regist,
    poster: poster,
    plateInfo: plateInfo,
    addPoster: addPoster
  },
  created() {
    //检测token过期
    let that = this;
    that.$axios
      .get("/user/findUserMine", {
        headers: {
          token: localStorage.getItem("token"),
        },
      })
      .then(function (response) {
        if (response.data.hasOwnProperty("errmsg")) {
          let here = that;
          here.$axios
            .get("/user/findUserMine", {
              headers: {
                token: that.$route.params.token,
              },
            })
            .then(function (response2) {
              if (response2.data.hasOwnProperty("errmsg")) {
                alert("登陆过期，请重新登录！");
                window.open("/#/login", (name = "_self"));
              }
            });
        }
      });
    
    this.$axios.get('/section/findSectionBysId',{
      params:{
        sectionId:this.getSectionId(),
      },
      headers:{
        token:this.getToken(),
      }
    }).then(function(response){
      if(response.data.hasOwnProperty('sectionId')){
        console.log('## '+response.data.user.userAccount+ " "+localStorage.getItem('myAccount'));
        if(response.data.userCreater.userAccount == localStorage.getItem('myAccount')){
          that.showAdminButton = true;
        }
      }
    })
  },
  methods: {
    toAdmin(){
      window.open("/#/adminpage");
    },
    doFollow() {
      let that = this;
      that.isUse = true;
      that.axios({
        method: "post",
        url: "/sectionUser/insertSectionUser",
        params: {
          sectionId: that.getSectionId(),
        },
        headers: {
          token: that.getToken(),
        },
      });
      setTimeout(function () {
        location.reload();
      }, 500);
    },
    checkFollow(list) {
      let that = this;
      return list.sectionId == that.getSectionId();
    },
    toTie: function (id, content) {
      localStorage.setItem("id", id);
      localStorage.setItem("Sid", this.getSectionId());
      localStorage.setItem("content", content);
      window.open('/#/tie',name='_self');
    },
    getToken() {
      let that = this;
      if (typeof that.$route.params.token == "undefined") {
        console.log(localStorage.getItem("token"));
        return localStorage.getItem("token");
      } else {
        return that.$route.params.token;
      }
    },
    getSectionId() {
      let that = this;
      if (typeof that.$route.params.sectionId == "undefined") {
        return Number(localStorage.getItem("sectionId"));
      } else {
        return that.$route.params.sectionId;
      }
    },
    getIsFollow() {
      let that = this;
      return that.axios({
        method: "get",
        url: "/user/findUserMine",
        headers: {
          token: that.getToken(),
        },
      });
    },
    getAllPost() {
      let that = this;
      return that.axios({
        method: "get",
        url: "/sectionPost/findAllSectionPost",
        params: {
          sectionId: that.getSectionId(),
        },
        headers: {
          token: that.getToken(),
        },
      });
    },
    getSectionInfo() {
      let that = this;
      return that.axios({
        method: "get",
        url: "/section/findSectionBysId",
        params: {
          sectionId: that.getSectionId(),
        },
        headers: {
          token: that.getToken(),
        },
      });
    },
  },
  mounted() {
    let that = this;
    that.axios
      .all([that.getAllPost(), that.getSectionInfo(), that.getIsFollow()])
      .then(
        that.axios.spread(function (allPost, info, isFollow) {
          console.log(allPost);
          console.log(info);
          console.log(isFollow);
          let here = that;
          here.sections = allPost.data;
          here.info = info.data;
          here.sectionList = isFollow.data.sectionList;
          here.realSectionId = info.data.sectionId;
        })
      );
    setTimeout(function () {
      if (
        that.sectionList.some((item) => {
          console.log("christina");
          return item.sectionId == that.getSectionId();
        })
      ) {
        console.log("hh");
        let here = that;
        here.isUse = true;
        here.situationFollow = "已关注";
      }
    }, 500);
  },
};
</script>

<style>
#plate {
  display: flex;
  flex-wrap: wrap;
}

#plate .banner {
  background-color: blueviolet;
  margin: 10px;
  height: 60px;
  width: 100%;
  border-radius: 5px;
}

#plate .sub-banner {
  display: flex;
  margin: 0 10px;
  height: 100px;
  width: 100%;
}

#plate .page {
  display: flex;
  margin: 10px;
  width: 100%;
}

#plate .sub-banner .top {
  display: flex;
  flex: 5;
  align-items: center;
  background-color: skyblue;
  margin-right: 5px;
  height: 100px;
  width: 100%;
  border-radius: 5px;
}

#plate .sub-banner .top .add {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 80px;
}

#plate .sub-banner .top .add .add-post {
  text-align: center;
  width: 100px;
  height: 40px;
  border-width: 0px;
  border-radius: 5px;
  background: #1e90ff;
  line-height: 40px;
  color: white;
  outline: none;
  cursor: pointer;
}
#plate .sub-banner .register {
  display: flex;
  flex: 1;
  flex-direction: column;
  background-color: skyblue;
  margin-left: 5px;
  width: 100%;
  border-radius: 5px;
}

#plate .page .area {
  display: flex;
  flex-wrap: wrap;
  flex: 5;
  background-color: skyblue;
  margin-right: 5px;
  width: 100%;
  border-radius: 5px;
}

#plate .page .msg {
  display: flex;
  flex-wrap: wrap;
  flex: 1;
  align-items: center;
  background-color: skyblue;
  margin-left: 5px;
  width: 100%;
  border-radius: 5px;
}

.top .pic {
  height: 80px;
  width: 80px;
  margin-left: 10px;
  border-radius: 5px;
  box-shadow: 1px 2px 3px 0.4px;
  cursor: pointer;
}

.top .pic img {
  height: 80px;
  width: 100%;
  border-radius: 5px;
}
</style>