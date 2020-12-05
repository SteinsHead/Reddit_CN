<template>
  <div>
    <input
      @input="input"
      :placeholder="placeholder"
      :style="style_parameter"
      class="base_input"
      :type="content_type"
    />
  </div>
</template>

<script>
export default {
  props: {
    placeholder: String,
    content_type: String,
    style_parameter: {},
  },
  methods: {
    input: function (e) {
      this.value = e.target.value;
    },
  },
  data() {
    return {
      value: "",
    };
  },
};
</script>

<style scope>
.base_input {
  padding: 0px;
  border: none;
  height: 30px;
  padding-left: 22px;
  background-size: 20px;
  background-repeat: no-repeat;
  background-position-x: left;
  background-position-y: center;
  transition: 0.5s ease-in-out;
  margin: 10px;
}
</style>