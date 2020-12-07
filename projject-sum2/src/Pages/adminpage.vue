<template>
  <div id="admin">
    <div class="banner">
      <div class="left">
        <userCount
          :itemname="user"
          :count="usercount"
          :quantity="userquantity"
        ></userCount>
        <activeCount
          :itemname="active"
          :count="activecount"
          :quantity="activequantity"
        ></activeCount>
        <banCount
          :itemname="ban"
          :count="bancount"
          :quantity="banquantity"
        ></banCount>
        <areaCount
          :itemname="area"
          :count="areacount"
          :quantity="areaquantity"
        ></areaCount>
      </div>

      <div class="right">
        <search
          :style_parameter="style_parameter"
          :content_type="content_type"
          :placeholder="placeholder"
        ></search>
        <svg
          t="1606730577736"
          class="icon"
          viewBox="0 0 1024 1024"
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
          p-id="3096"
          width="40"
          height="40"
        >
          <path
            d="M416 405.333q32 0 32 32v64q0 32-32 32t-32-32v-64q0-32 32-32zM629.333 405.333q32 0 32 32v64q0 32-32 32t-32-32v-64q0-32 32-32z"
            fill="#d4237a"
            p-id="3097"
          ></path>
          <path
            d="M850.603 837.056A467.456 467.456 0 0 0 981.333 512c0-258.773-210.517-469.333-469.29-469.333C253.184 42.56 42.667 253.12 42.667 512c0 258.773 210.517 469.333 469.29 469.333h341.888c16.662 0 31.766-9.642 38.784-24.64a42.773 42.773 0 0 0-5.76-45.61m-97.216 1.578H512C291.093 912.64 111.36 732.907 111.36 512S291.093 111.36 512 111.36 912.64 291.093 912.64 512a398.72 398.72 0 0 1-111.595 277.44c-32.085 33.28-29.461 79.296-11.392 123.221z"
            fill="#d4237a"
            p-id="3098"
          ></path>
        </svg>
        <div class="head">
          <img
            src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg"
            alt=""
          />
        </div>
      </div>
    </div>

    <div class="chartAll">
      <chart></chart>
      <chart></chart>
      <chart></chart>
    </div>
  </div>
</template>

<script>
import Data from "@/components/data";
import search from "@/components/input";
import chart from "@/components/charts";
import footerspace from "@/components/footerSpace";

export default {
  name: "admin",
  data() {
    return {
      user: "用户数量",
      usercount: 1234,
      userquantity: "人",

      active: "活跃人数",
      activecount: 2,
      activequantity: "人",

      ban: "封禁人数",
      bancount: 3,
      banquantity: "人",

      area: "板块数量",
      areacount: 123,
      areaquantity: "个",

      style_parameter: {
        backgroundImage:
          "url('https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg')",
      },
      content_type: "text",
      placeholder: "今天想搜索什么 ……",
    };
  },
  components: {
    userCount: Data,
    activeCount: Data,
    banCount: Data,
    areaCount: Data,
    search: search,
    chart: chart,
  },
};
</script>

<style>
.banner {
  display: flex;
  margin: 10px;
  background-color: blueviolet;
  border-radius: 5px;
  height: 60px;
}

svg {
  margin-left: 20px;
}

.head {
  margin-left: 20px;
  margin-right: 20px;
  height: 40px;
}

.head img {
  height: 100%;
}

.banner .left {
  flex: 1;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.banner .right {
  flex: 1;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.chartAll {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
}
</style>