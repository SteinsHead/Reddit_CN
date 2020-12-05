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
            <addPoster :token="realToken" :sectionId="100001"></addPoster>
          </el-dialog>
        </div>
        <div class="sectionFollow">
          <el-button type="primary" plain round :disabled="isUse" @click="doFollow">{{situationFollow}}</el-button>
        </div>
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
        ></poster>
      </div>
      <div class="msg">
        <plateInfo :masterInfo="info.sectionName" :ruleInfo="info.sectionIntroduce"></plateInfo>
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
      addPost: "发帖",
      sections: [],
      info: {},
      visible: false,
      realToken: localStorage.getItem("token"),
      situationFollow: "未关注",
      isUse: false,
      sectionList: [],
    };
  },
  components: {
    regist: regist,
    poster: poster,
    plateInfo: plateInfo,
    addPoster: addPoster,
  },
  methods: {
    // doFollow(){
    //   let that = this;
    //   if(that.sectionList.some(function(item, index, that.sectionList){
    //     return (item.sectionId == );
    //   })){

    //   }else{

    //   }
    // },
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
    getIsFollow(){
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
      .then(that.axios.spread(function(allPost, info, isFollow){
        console.log(allPost);
        console.log(info);
        console.log(isFollow);
        let here = that;
        here.sections = allPost.data;
        here.info = info.data;
        here.sectionList = isFollow.data.sectionList;
      }));
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

#plate .sub-banner .top .add .sectionFollow {

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