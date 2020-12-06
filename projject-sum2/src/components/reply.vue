<template>
  <div><span id="reply-span">{{from}}&nbsp;回复说:&nbsp;{{content}}</span></div>
</template>

<script>
export default {
    props:{
        from:String,
        to:String, //没用
        content:String
    }
}
</script>

<style>
#reply-span{
    padding-left: 20px;
    display: flex;
    justify-content: left;
    font-size: 12px;
    cursor: pointer;
}
</style>