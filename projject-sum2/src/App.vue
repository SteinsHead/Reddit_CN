<template>
  <div id="app">
    <topavg></topavg>
    <router-view />
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

/* .footercopy {
  width: 100%;
  position: fixed;
  bottom: 10px;
  justify-content: center;
  align-items: center;
} */
</style>
