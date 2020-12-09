<template>
  <div id="banner">
    <div class="image" @click="onJumptoMine">
      <img
        :src="imgUrl"
        alt=""
        srcset=""
        onerror="this.src='https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg'"
      />
    </div>
    <div class="left">
      <firstPage :label="firstpage" :textStyle="centerStyle"></firstPage>
      <talkBlock :label="talkblock" :textStyle="centerStyle"></talkBlock>
      <rankScore :label="rankscore" :textStyle="centerStyle"></rankScore>
      <downLoad :label="download" :textStyle="centerStyle"></downLoad>
    </div>
    <div class="between">
      <!-- <search
        :style_parameter="style_parameter"
        :content_type="content_type"
        :placeholder="placeholder"
      ></search> -->
      <el-autocomplete
        v-model="state"
        prefix-icon="el-icon-search"
        :fetch-suggestions="querySearchAsync"
        placeholder="想搜索什么吧？"
        @select="handleSelect"
      ></el-autocomplete>
    </div>
    <div class="right">
      <welcome v-html="welcomeMsg" :textStyle="welcomeStyle"></welcome>
      <logOut
        @click.native="jumpToLogin"
        :label="logout"
        :textStyle="centerStyle"
      ></logOut>
      <messAge :label="message" :textStyle="centerStyle"></messAge>
    </div>
  </div>
</template>

<script>
import block from "@/components/topBlock";
import search from "@/components/input";
export default {
  name: "banner",
  data() {
    return {
      firstpage: "首页",
      talkblock: "论坛",
      rankscore: "评分",
      download: "app下载",
      welcomeMsg: "欢迎登录<br>",
      logout: "登出",
      message: "消息",
      placeholder: "今天想搜索什么 ……",
      content_type: "text",
      style_parameter: {
        backgroundImage:
          "url('https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg')",
      },
      welcomeStyle: {},
      centerStyle: {},
      imgUrl: "",
    };
  },
  props: {
    token: {
      type: String,
    },
  },
  components: {
    firstPage: block,
    talkBlock: block,
    rankScore: block,
    downLoad: block,
    welcome: block,
    logOut: block,
    messAge: block,
    search: search,
  },
  methods: {
    querySearchAsync(){

    },
    handleSelect(){

    },
    jumpToLogin() {
      window.open("/#/login", "_self");
    },
    onJumptoMine() {
      window.open("/#/mine", "_self");
    },
  },
  mounted() {
    let that = this;
    that
      .axios({
        method: "get",
        url: "/user/findUserMine",
        headers: {
          token: that.token,
        },
      })
      .then(function (response) {
        console.log(response);
        that.welcomeMsg += response.data.userName;
        console.log(response.data.userPhoto);
        that.imgUrl =
          "https://redditcn-1301983393.cos.ap-beijing.myqcloud.com/" +
          response.data.userPhoto;
      })
      .catch(function (error) {
        console.log(error);
      });
  },
};
</script>

<style scoped>
#banner {
  display: flex;
  width: 100%;
  height: 60px;
  background-color: purple;
}

.image {
  width: 75px;
  height: 60px;
  border-radius: 50%;
  cursor: pointer;
}

.image img {
  height: 100%;
  border-radius: 50%;
}

#banner .left {
  display: flex;
  justify-content: flex-start;
}

#banner .right {
  flex: 1;
  display: flex;
  justify-content: flex-end;
}

#banner .between {
  display: flex;
  flex: 1;
  align-items: center;
  justify-content: center;
}
</style>