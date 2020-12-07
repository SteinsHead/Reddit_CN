<template>
  <div id="app">
    <topavg></topavg>
    <!-- <transition name="slide-fade">
      <router-view></router-view>
    </transition> -->
    <router-view></router-view>
    <!-- <div class="footercopy">
      <footerSpace :copyright="rightMsg"></footerSpace>
    </div> -->
  </div>
</template>

<script>
import topAvg from "@/components/toTop";
// import footerspace from "@/components/footerSpace";
export default {
  name: "App",
  components: {
    topavg: topAvg,
    // footerSpace: footerspace,
  },
};
</script>

<style>
::-webkit-scrollbar {
  width: 6px;
  height: 6px;
  background-color: #f5f5f5;
}

::-webkit-scrollbar-thumb {
  border-radius: 10px;
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #10098f;
}

::-webkit-scrollbar-track {
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  background-color: #f5f5f5;
}

html,
body {
  height: 100%;
}

#app {
  /* height: 100%; */
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
  padding: 0;
  border: 0;
  overflow-x: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
/* .slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-to{
  transform: translateX(10px);
  opacity: 0;
} */

/* .footercopy {
  width: 100%;
  position: fixed;
  bottom: 10px;
  justify-content: center;
  align-items: center;
} */
</style>
