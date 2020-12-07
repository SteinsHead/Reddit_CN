<template>
  <div class="footspace">
    <div class="copyright">
      <p>{{ copyright }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    copyright: "",
  },
};
</script>

<style>
.footerspace {
  margin: 0 auto;
  display: flex;
  cursor: pointer;
  position: fixed;
}

.copyright {
  font-size: 10px;
  color: #404142;
}

.copyright p {
  word-spacing: 1px;
  line-height: 25px;
}
</style>