	var integralModule = angular.module("adminPieMapApp",[]);
			integralModule.controller("adminPieMapCtrl",function($http,$scope){
				initBind($http, $scope);
				// pieMap();
				//初始化时间
				lay('#version').html('-v'+ laydate.v);
				//执行一个laydate实例
				laydate.render({
				  elem: '#startDate'//指定元素
				});
				laydate.render({
				  elem: '#endDate'//指定元素
				});
				
			});
			
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			function initBind($http, $scope) {
				option = null;
				option = {
				    title : {
				        text: '销售占比饼图',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data: ['肉制类','饮料类','膨化类','其他']
				    },
				    series : [
				        {
				            name: '访问来源',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
				$("#serchAdminPieMap").on('click',function(){
					pieMap();
				})
			}
			function pieMap(){
				//获得图表的options对象  
				var options =option;  
				$.ajax({
					url:'/mymall'+'/admin/map/adminPieMapList',
					data:{
						"startDate":$("#startDate").val(),
						"endDate":$("#endDate").val(),
					},
					type:'post',
					dataType:"json",
					success: function (result) {
						options.series[0].data = result;  
						myChart.hideLoading();  
						myChart.setOption(options); 
					}
				});
			}