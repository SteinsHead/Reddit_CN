<template>
  <div id="page">
    <topbanner></topbanner>
    <div class="navig">
      <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
      <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
      <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
    </div>

    <div class="block">
      <areablock
        v-for="plate in plateblock"
        :key="plate.sectionId"
        :title="plate.sectionIntroduce"
        :blockName="plate.sectionName"
        :borderStyle="borderstyle"
        :followSituation="plate.sectionFollow"
        @click.native="jumpToSubSection(plate)"
      ></areablock>
    </div>
    <div class="footercopy">
      <footerSpace :copyright="rightMsg"></footerSpace>
    </div>
  </div>
</template>

<script>
import banner from "@/components/topBanner";
import areablock from "@/components/areaBlock";
import navigater from "@/components/navigater";
import footerspace from "@/components/footerSpace";
export default {
  name: "page",
  data() {
    return {
      blockLabel: "分区A",
      blockname: "板块A",
      navname: "Raddit",
      rightMsg: "© 2020 · Theme by christina · All Rights Reserved",
      textcolor: {
        color: "white",
      },
      borderstyle: {
        borderRadius: "5px",
        cursor: "pointer",
      },
      plateblock: [],
      token: localStorage.getItem("token"),
    };
  },
  components: {
    topbanner: banner,
    areablock: areablock,
    naviGater: navigater,
    footerSpace: footerspace,
  },
  methods: {
    jumpToSubSection(plate) {
      let that = this;
      console.log(typeof(plate.sectionId.toString()));
      localStorage.setItem("sectionId", plate.sectionId.toString())
      this.$router.push({
        name: "plate",
        params: {
          sectionId: plate.sectionId,
          token: that.token,
        },
      });
      window.open("/#/platepage", (name = "_self"));
    },
  },
  mounted() {
    let that = this;
    localStorage.setItem(
      "token",
      "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOjEwMDAwNCwiZXhwIjoxNjA3MTY5MTI3fQ.CpUXpZZXC6E0KkSbk1zKDA8YIi8RPV0tgrav23aSiA4"
    );
    that
      .axios({
        method: "get",
        url: "/section/findAllSection",
        headers: {
          token: localStorage.getItem("token"),
        },
      })
      .then(function (response) {
        console.log(response.data);
        that.plateblock = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
  },
};
</script>

<style>
#page {
  background: gray;
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  width: 100%;
  height: 100%;
}

.navig {
  display: flex;
}

.footercopy {
  width: 100%;
  position: fixed;
  bottom: 10px;
  justify-content: center;
  align-items: center;
}

.block {
  display: flex;
  flex-wrap: wrap;
}
</style>