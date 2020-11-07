<template>
  <div id="block">
    <div class="label" :style="textStyle">
      <a
        href="www.baidu.com"
        style="text-decoration: none"
        :style="hrefStyle"
        >{{ label }}</a
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "block",
  data() {
    return {};
  },
  props: {
    label: "",
    textStyle: {},
    hrefStyle: {
      corsur: "pointer",
    },
  },
};
</script>

<style scoped>
#block {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 60px;
}

#block a {
  color: skyblue;
}
</style>