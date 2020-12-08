<template>
  <div id="plateinfo">
    <div class="master">
      <p>{{ masterInfo }}</p>
      <img
        src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg"
        alt=""
        srcset=""
      />
    </div>
    <div class="rule">
      <p>{{ ruleInfo }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "plateinfo",
  data() {
    return {
      
    };
  },
  props: {
    masterInfo: "",
    ruleInfo: "",
  },
};
</script>

<style>
#plateinfo {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  flex-direction: column;
  margin: 10px;
  width: 100%;
  border-radius: 5px;
  background-color: aliceblue;
}

#plateinfo .master {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: aqua;
  border-radius: 5px;
  margin: 10px;
  box-shadow: 1px 2px 3px 0.4px;
}

#plateinfo .master p {
  margin: 10px;
}

#plateinfo .master img {
  width: 50px;
  height: 100%;
  margin: 10px;
  border-radius: 5px;
}

#plateinfo .rule {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  background-color: aqua;
  border-radius: 5px;
  margin: 10px;
  box-shadow: 1px 2px 3px 0.4px;
}

#plateinfo .rule p {
  margin: 10px;
}
</style>