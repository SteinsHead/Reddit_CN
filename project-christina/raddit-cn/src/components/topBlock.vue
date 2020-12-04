<template>
  <div id="block">
    <div class="label" :style="textStyle">
      <p>{{ label }}</p>
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

#block p {
  color: skyblue;
  cursor: pointer;
}
</style>