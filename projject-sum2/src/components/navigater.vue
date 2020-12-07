<template>
  <div class="navigater">
    <el-popover
      placement="right"
      title="开始创建"
      width="300"
      trigger="hover"
      content="你可以根据自己的兴趣爱好创建自己的贴吧，注意需要提供：贴吧的照片、自我介绍、贴吧的名字"
    >
      <el-tag slot="reference">{{ navName }}</el-tag>
    </el-popover>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    navName: "",
  },
};
</script>

<style>
.navigater {
  margin: 20px 20px 50px 50px;
  cursor: pointer;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
</style>