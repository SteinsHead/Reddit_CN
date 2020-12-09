<template>
  <div id="page">
    <topbanner :token="token"></topbanner>
    <div class="carousel">
      <el-carousel indicator-position="outside" height="150px">
        <el-carousel-item v-for="item in imgBox" :key="item">
          <img :src="item" alt="" srcset="" />
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="navig">
      <naviGater @click.native="visible = true" :navName="navname"></naviGater>
      <el-dialog :visible.sync="visible">
        <platedialog :token="token"></platedialog>
      </el-dialog>
    </div>
    <div class="block">
      <areablock
        v-for="plate in plateblock"
        :sectionUrl="plate.sectionPhoto"
        :key="plate.sectionId"
        :title="plate.sectionIntroduce"
        :blockName="plate.sectionName"
        :borderStyle="borderstyle"
        :followSituation="plate.sectionFollow"
        @click.native="jumpToSubSection(plate)"
      ></areablock>
    </div>
  </div>
</template>

<script>
import banner from "@/components/topBanner";
import areablock from "@/components/areaBlock";
import navigater from "@/components/navigater";
import plateDialog from "@/components/addPlate";
export default {
  name: "page",
  data() {
    return {
      visible: false,
      blockLabel: "分区A",
      blockname: "板块A",
      navname: "创建板块",
      rightMsg: "© 2020 · Theme by christina · All Rights Reserved",
      borderstyle: {
        borderRadius: "5px",
        cursor: "pointer",
      },
      plateblock: [],
      token: localStorage.getItem("token"),
      imgBox: [
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20160831_10.jpg',
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20160831_6.jpg',
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20160831_7.jpg',
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20190322_6.jpg',
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20160831_13.jpg',
        'https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/20160831_5.jpg',
      ],
    };
  },
  components: {
    topbanner: banner,
    areablock: areablock,
    naviGater: navigater,
    platedialog: plateDialog,
  },
  created() {
    //检测token过期
    let that = this;
    that.$axios
      .get("/user/findUserMine", {
        headers: {
          token: localStorage.getItem("token"),
        },
      })
      .then(function (response) {
        if (response.data.hasOwnProperty("errmsg")) {
          let here = that;
          here.$axios
            .get("/user/findUserMine", {
              headers: {
                token: that.$route.params.token,
              },
            })
            .then(function (response2) {
              if (response2.data.hasOwnProperty("errmsg")) {
                alert("登陆过期，请重新登录！");
                window.open("/#/login", (name = "_self"));
              }
            });
        }
      });
  },
  methods: {
    insertPlate() {},
    jumpToSubSection(plate) {
      let that = this;
      console.log(typeof plate.sectionId.toString());
      localStorage.setItem("sectionId", plate.sectionId.toString());
      this.$router
        .push({
          name: "plate",
          params: {
            sectionId: plate.sectionId,
            token: that.token,
          },
        })
        .catch((err) => {
          console.log(err);
        });
      window.open("/#/platepage", (name = "_self"));
    },
  },
  mounted() {
    let that = this;
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

.block {
  display: flex;
  flex-wrap: wrap;
}
</style>