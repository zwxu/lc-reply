webpackJsonp([1,3],{33:function(t,s){"use strict";t.exports={data:function(){return{pager:{start:1,limit:10,total:0},size:0,start:0,page_num:1,loading:!1,studentList:{}}},events:{jump:function(t){console.log("--------jump--------------");var s=this;s.page_num=t,s.page(t)}},methods:{page:function(t){var s=this;s.loading=!0,setTimeout(function(){console.log("set time out"),s.loading=!1},1e3),s.$am.ajax({url:$ApiConf.api_student_list,success:function(e){s.studentList=e.studentList;var d=s.studentList,o=d.length,a=10*(t-1);o-a<10?s.size=o-a:s.size=10,s.$set("total",o),s.start=a,s.pager.total=o,s.pager.start=t}})}},route:{activate:function(t){console.log("dq activate");var s=this;document.title=s.$route.menuName+"-小米金融",t.next()}},ready:function(){var t=this;console.log(" ready "),t.page(1)}}},82:function(t,s){t.exports=' <div id=loadingOrder class=u-load v-if=loading><em class=icn-load></em>努力加载中...</div> <div class=table-responsive v-else> <table class=u-table2> <tr> <td colspan=7 style="font-weight: bold">学生列表</td> </tr> <tr> <td> 姓名 </td> <td> 学号 </td> <td> 所在学院 </td> <td> 答辩小组 </td> <td> 通过票数 </td> <td> 不通过票数 </td> <td> 答辩状态 </td> </tr> <tbody v-for="i in size "> <tr> <td> {{studentList[i + start].username}} </td> <td> {{studentList[i + start].number}} </td> <td> {{studentList[i + start].school}} </td> <td> {{studentList[i + start].groupid}} </td> <td> {{studentList[i + start].pass_count}} </td> <td> {{studentList[i + start].reject_count}} </td> <td> {{studentList[i + start].status}} </td> </tr> </tbody> <tr> <td colspan=6></td> </tr> <tr> <td colspan=2 style="font-weight: bold">总计</td> <td>{{total}}</td> </tr> </table> <pagination :query.sync=pager></pagination> </div> '},90:function(t,s,e){var d,o;d=e(33),o=e(82),t.exports=d||{},t.exports.__esModule&&(t.exports=t.exports["default"]),o&&(("function"==typeof t.exports?t.exports.options:t.exports).template=o)}});