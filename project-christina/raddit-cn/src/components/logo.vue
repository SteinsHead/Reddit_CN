<template>
  <div id="test">
    <input type="text" v-model="parentMessage" placeholder="input...">
    <HelloWorld :style="backwife" :msgShare="parentMessage" :textStyle="newStyle"></HelloWorld>
  </div>
</template>

<script>
import HelloWorld from "@/components/HelloWorld";

export default {
  name: "logo",
  data() {
    return {
      aaa: 'aaa',
      parentMessage: '',
      newStyle: {
        marginTop: 200 + 'px',
        fontSize: 40 + 'px',
        
      },
      backwife: {
        backgroundImage: 'url("https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg")',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      },
    };
  },
  components: {
    HelloWorld: HelloWorld,
  },
};
</script>

<style>
</style>