<template>
  <div id="areablock" :style="borderStyle">
    <div class="img">
      <img
        src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg"
        alt=""
        srcset=""
      />
    </div>
    <div class="blockInfo" :style="borderStyle">
      <p>{{ blockName }}</p>
      <div class="title">
        <p>{{ title }}</p>
      </div>
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
    title: "",
    blockName: "",
    borderStyle: {},
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
}

#areablock .img {
  margin: 20px;
  width: 50px;
  height: 50px;
}

#areablock .img img {
  height: 100%;
}
</style>