<template>
  <div id="box">
      <div id="head"><p>{{from}}&nbsp;回复{{to}}说:</p></div>

      <div><p>{{content}}</p></div>
  </div>
</template>

<script>
export default {
    props:{
        from:String,
        to:String,
        content:String
    }
}
</script>

<style>

#box{    
    border-radius: 5px;
    margin-top: 10px;
    background-color: white;
    border: 1px solid white;
    display: flex;
    flex-direction: column;
}
#head{
    margin-left: 20px;
    display:flex;
    justify-content: left;
    align-items: center;

}
p{
    font-size: 12px;
}
</style>