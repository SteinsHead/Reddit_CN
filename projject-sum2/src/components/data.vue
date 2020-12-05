<template>
  <div id="Data">
      <p>{{itemname}}</p>
      <p>{{count}}</p>
      <p>{{quantity}}</p>
  </div>
</template>

<script>
export default {
    name: "Data",
    data() {
        return {

        }
    },
    props: {
        itemname: "",
        count: "",
        quantity: "",
    },
}
</script>

<style>
#Data {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 150px;
    height: 40px;
}
</style>