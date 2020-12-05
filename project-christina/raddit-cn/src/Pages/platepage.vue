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
        <plateInfo :masterInfo="masterinfo" :ruleInfo="ruleinfo"></plateInfo>
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
      visible: false,
      realToken: "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOjEwMDAwMiwiZXhwIjoxNjA3MTAwMDQ0fQ.dpPiabXPc3gzeQw1RC3nmyLxZRfeHcbhVXpamLDAHLQ",
    };
  },
  components: {
    regist: regist,
    poster: poster,
    plateInfo: plateInfo,
    addPoster: addPoster,
  },
  mounted() {
    let that = this;
    that
      .axios({
        method: "get",
        url: "/sectionPost/findAllSectionPost",
        params: {
          sectionId: 100001,
        },
        headers: {
          token:
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOjEwMDAwMiwiZXhwIjoxNjA3MTAwMDQ0fQ.dpPiabXPc3gzeQw1RC3nmyLxZRfeHcbhVXpamLDAHLQ",
        },
      })
      .then(function (response) {
        that.sections = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
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
  background: #1E90FF;
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