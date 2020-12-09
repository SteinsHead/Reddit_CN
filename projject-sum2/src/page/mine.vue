<template>
  <div v-if="showPage" id="container">
    <el-dialog :visible.sync="visible">
        <changePerMsg></changePerMsg>
    </el-dialog>
    <displayCase :image="'https://redditcn-1301983393.cos.ap-beijing.myqcloud.com/'+userData.userPhoto"></displayCase>
    <imageFrame :imageSrc="'https://redditcn-1301983393.cos.ap-beijing.myqcloud.com/'+userData.userPhoto"></imageFrame>
    <div id="mainbox">
      <div id="div_name">
        <span id="username">{{userData.userName}}</span>
        <myButton
          @click.native="visible = true"
          :style_parameter="buttonStyle1"
          msg="修改个人资料"
        ></myButton>
      </div>
      <span id="myCoin">{{userData.userIntroduce}}</span>
      <banner @listenToChildEvent="showMsg"></banner>

      <div v-if="content_control == 1" id="contentbox1">
        <div v-for="(section, index) in sectionList" :key="index">
          <div id="level">
            <blockLv
              :sectionId='section.sectionId'
              :sectionName="section.sectionName"
              :sectionLv="section.sectionUser.sectionUserRank"
            ></blockLv>
          </div>
        </div>
      </div>      
    </div>
    <!--返回顶部-->
    <toTop></toTop>
  </div>
</template>

<script>
import image1 from "@/assets/二乔.jpg";

import simple_tie from "@/components/simple_tie.vue";
import toTop from "@/components/toTop.vue";
import achievement from "@/components/achievement.vue";
import displayCase from "@/components/displayCase.vue";
import imageFrame from "@/components/imageFrame.vue";
import banner from "@/components/banner.vue";
import blockLv from "@/components/blockLv.vue";
import BlockLv from "@/components/blockLv.vue";
import Achievement from "@/components/achievement.vue";
import Simple_tie from "@/components/simple_tie.vue";
import myButton from "@/components/button.vue";
import myInput from "@/components/input.vue";
import changePerMsg from "@/components/changePerMsg.vue";

export default {
  components: {
    displayCase: displayCase,
    imageFrame: imageFrame,
    banner: banner,
    blockLv: blockLv,
    toTop: toTop,
    achievement: achievement,
    simpleTie: simple_tie,
    myButton: myButton,
    myInput: myInput,
    changePerMsg: changePerMsg,
  },
  data() {
    return {
      showPage:false,
      userData:null,
      sectionList:[],

      visible: false,
      change: false,
      buttonStyle1: {
        width: "100px",
        borderRadius: "5px",
      },
      buttonStyle2: {
        backgroundColor: "#3f89ec",
        borderRadius: "5px",
      },
      content_control: 1,
      image1: image1,
    };
  },
  created: function () {
    let that = this;
    this.$axios
      .get("/user/findUserMine", {
        headers: {
          token: localStorage.getItem("token"),
        },
      })
      .then(function (response) {
        if (response.data.hasOwnProperty("errmsg")) {
          let here = that;
          that.$axios
            .get("/user/findUserMine", {
              headers: {
                token: that.$route.params.token,
              },
            })
            .then(function (response2) {
              if (response.data.hasOwnProperty("errmsg")) {
                alert("登陆过期，请重新登录！");
                window.open("/#/login", (name = "_self"));
              }
              
              here.userData = response2.data;
              here.sectionList = response2.data.sectionList;
              here.showPage = true;
            });
        } else {
          that.userData = response.data;
          that.sectionList = response.data.sectionList;
        }

        that.showPage = true;
      });
  },
  methods: {
    toChange: function () {
      this.change = true;
    },
    showMsg: function (data) {
      this.content_control = data;
    },
  },
};
</script>

<style>
#buttonMine {
  position: absolute;
  right: 0;
}
#div_name {
  position: relative;
  display: flex;
  flex-direction: row;
}
#username {
  position: relative;
  left: -200px;
}
#mainbox {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #eeeeec;
  position: relative;
  top: -120px;
}
#contentbox {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(235, 243, 247);
  position: relative;
  top: -25px;
  width: 1000px;
  height: 1000px;
  border: 2px solid white;
}
#twoButton {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
#contentbox1 {
  display: flex;
  background-color: rgb(235, 243, 247);
  position: relative;
  top: -25px;
  width: 1000px;
  height: 1000px;
  border: 2px solid white;
}
#level {
  position: relative;
  margin: 30px;
}
#myCoin {
  margin-top: 30px;
  font-size: 12px;
  position: relative;
  left: -200px;
}
#change_div {
  z-index: 10;
  background-color: white;
  top: 30%;
  left: 40%;
  position: fixed;
  display: flex;
  flex-direction: column;
  justify-content: center;
  border-radius: 10px;
  border: 5px solid white;
  box-shadow: 1px 1px 1px black;
}
</style>