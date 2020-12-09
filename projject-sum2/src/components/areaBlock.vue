<template>
  <div id="areablock" :style="borderStyle">
    <div class="img">
      <img
        :src="sectionUrl"
        alt=""
        srcset=""
        onerror="this.src='https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg'"
      />
    </div>
    <div class="blockInfo" :style="borderStyle">
      <el-tag style="margin: 10px">{{ blockName }}吧</el-tag>
      <div class="title">
        <el-tag>{{ title }}~</el-tag>
      </div>
    </div>
    <div class="follow">
      <el-tag>{{ followSituation }}人关注</el-tag>
    </div>
  </div>
</template>

<script>
export default {
  name: "areablock",
  data() {
    return {};
  },
  props: {
    sectionUrl: {
      type: String,
    },
    title: "",
    blockName: "",
    borderStyle: {},
    followSituation: "",
  },
  mounted() {
    let that = this;
    that.sectionUrl =
      "https://redditcn-1301983393.cos.ap-beijing.myqcloud.com/" +
      that.sectionUrl;
  },
};
</script>

<style>
#areablock {
  display: flex;
  align-items: center;
  margin: 50px;
  height: 100px;
  width: 400px;
  background-color: skyblue;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}

#areablock .img {
  display: flex;
  justify-content: flex-start;
  margin: 20px;
  width: 50px;
  height: 50px;
}

#areablock .img img {
  height: 100%;
}

#areablock .blockInfo {
  display: flex;
  flex-direction: column;
}

#areablock .follow {
  display: flex;
  justify-content: flex-end;
  margin-left: 20px;
}

#areablock .follow p {
  margin: 0;
}
</style>