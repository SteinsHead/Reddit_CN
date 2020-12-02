<template>
  <div id="poster">
    <div class="postcount">
      <svg
        t="1606875452471"
        class="icon"
        viewBox="0 0 1024 1024"
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        p-id="3153"
        width="20"
        height="20"
      >
        <path
          d="M972.8 296.356157 972.8 101.928711C972.8 45.988474 927.066527 0 870.651428 0L153.348572 0C96.902287 0 51.2 45.635038 51.2 101.928711L51.2 922.071291C51.2 978.011525 96.933473 1024 153.348572 1024L870.651428 1024C927.097713 1024 972.8 978.364964 972.8 922.071291L972.8 625.689242 781.805839 816.346194 613.490627 656.262502 972.8 296.356157 972.8 296.356157ZM741.60855 856.472515C741.475661 856.440028 547.855921 919.27616 547.855921 919.27616 520.724081 928.080092 505.593412 913.170591 513.960464 886.296571L573.107901 696.32171C571.9923 697.50164 741.60855 856.472515 741.60855 856.472515L741.60855 856.472515ZM256 256C256 227.723021 279.330017 204.8 306.964356 204.8L717.035643 204.8C745.182479 204.8 768 227.525879 768 256 768 284.276979 744.669983 307.2 717.035643 307.2L306.964356 307.2C278.817519 307.2 256 284.474121 256 256L256 256ZM256 512C256 483.723021 278.718292 460.8 307.190143 460.8L460.809857 460.8C489.081392 460.8 512 483.525879 512 512 512 540.276977 489.281708 563.2 460.809857 563.2L307.190143 563.2C278.918608 563.2 256 540.474122 256 512L256 512ZM256 768C256 739.723023 278.664209 716.8 307.146576 716.8L358.453424 716.8C386.700898 716.8 409.6 739.525878 409.6 768 409.6 796.276977 386.935791 819.2 358.453424 819.2L307.146576 819.2C278.899102 819.2 256 796.474122 256 768L256 768Z"
          p-id="3154"
        ></path>
      </svg>
      <p>{{ postcount }}</p>
    </div>
    <div class="posttitle">
      {{ posttitle }}
    </div>
    <div class="postauthor">
      <p>{{ postauthor }}</p>
    </div>
    <div class="posttime">
      <p>{{ posttime }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "poster",
  data() {
    return {
      postcount: "4321",
      posttitle:
        "各位小伙伴来分享壁纸啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊",
      postauthor: "女王大人",
      posttime: "2020-12-02",
    };
  },
  props: {},
};
</script>

<style>
#poster {
  display: flex;
  width: 100%;
  margin: 10px;
  border-radius: 5px;
  background-color: crimson;
  box-shadow: 1px 2px 3px 0.4px;
  cursor: pointer;
}

#poster .postcount {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex: 1;
  margin: 10px;
  border-radius: 5px;
  background-color: skyblue;
}

#poster .postcount p {
    margin: 10px 0 0 0;
}

#poster .posttitle {
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 7;
  margin: 10px;
  border-radius: 5px;
  background-color: skyblue;
}

#poster .postauthor {
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 2;
  margin: 10px;
  border-radius: 5px;
  background-color: skyblue;
}

#poster .posttime {
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 1;
  margin: 10px;
  border-radius: 5px;
  background-color: skyblue;
}
</style>