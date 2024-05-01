<template>
  <div id="app">

    <template>
      <div class="common-layout">
        <el-container>
          <el-header style="text-align: right; font-size: 12px"><AppHeader></AppHeader></el-header>
          <el-container>
            <el-aside width="200px"><AppAside ></AppAside></el-aside>
            <el-container>
              <el-main>
                <router-view></router-view>
              </el-main>
            </el-container>
          </el-container>
        </el-container>
      </div>
    </template>

  </div>
</template>

<script>

import AppHeader from "@/layout/AppHeader.vue";
import AppAside from "@/layout/AppAside.vue";

export default {
  name: 'App',
  components: {
    AppAside,
    AppHeader
  }
}
</script>

<style>

.el-header, .el-footer{
  background-color: #32901e;
  color: white;
  line-height: 60px;
}
.el-aside{
  //background-color: #fafafa;
  color: #333;
  text-align: center;
  line-height: 200px;
}
.el-main{
  background-color: white;
  color: white;
  text-align: center;
//line-height: 160px;
}
body> .el-container{
  margin-bottom: 40px;
}
el-container:nth-child(5).aside,
el-container:nth-child(6).aside{
  line-height: 260px;
}
el-container:nth-child(7).aside{
  line-height: 320px;
}

</style>
