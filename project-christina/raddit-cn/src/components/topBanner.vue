<template>
  <div id="banner">
    <div class="image">
      <img
        src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg"
        alt=""
        srcset=""
      />
    </div>
    <div class="left">
      <firstPage :label="firstpage" :textStyle="centerStyle"></firstPage>
      <talkBlock :label="talkblock" :textStyle="centerStyle"></talkBlock>
      <rankScore :label="rankscore" :textStyle="centerStyle"></rankScore>
      <downLoad :label="download" :textStyle="centerStyle"></downLoad>
    </div>
    <div class="between">
      <search
        :style_parameter="style_parameter"
        :content_type="content_type"
        :placeholder="placeholder"
      ></search>
    </div>
    <div class="right">
      <welcome v-html="welcomeMsg" :textStyle="welcomeStyle"></welcome>
      <logOut @click.native="reverseUser" :label="logout" :textStyle="centerStyle"></logOut>
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
      welcomeMsg: "欢迎<br>christina",
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
    };
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
    reverseUser(){
      if(this.logout == "登出"){
        this.logout = "请登录";
      }else{
        this.logout = "登出";
      }
    }
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
}

.image img {
  height: 100%;
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