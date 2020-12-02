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
      </div>
      <div class="register">
        <regist></regist>
      </div>
    </div>
    <div class="page">
      <div class="area">
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
        <poster></poster>
      </div>
      <div class="msg">
        <plateInfo></plateInfo>
      </div>
    </div>
  </div>
</template>

<script>
import regist from "@/components/regist";
import poster from "@/components/post";
import plateInfo from "@/components/plateInfo";

export default {
  name: "plate",
  data() {
    return {};
  },
  components: {
    regist: regist,
    poster: poster,
    plateInfo: plateInfo,
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