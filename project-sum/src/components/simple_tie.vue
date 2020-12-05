<template>
    <div id="simple-tie">
        <div id="tie-head">
            <p id="tie-block">所属板块：{{block}}</p>
            <p id="tie-owner">发帖人：{{owner}}</p>
        </div>
        <div><p id="tie-theme">{{theme}}</p></div>
    </div>
</template>

<script>
export default {
    props:{
        block:String,
        owner:String,
        theme:String,
    }
}
</script>

<style>
#tie-head{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#simple-tie{
    margin-top: 30px;
    width: 80%;
    background-color: white;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
p{
    font-size: 12px;
}
</style>