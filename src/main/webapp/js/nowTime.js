(function($) {
	
	//给jQuery对象扩展方法
	$.fn.extend({
		nowTime: function() {
			//获得系统当前时间
			var date = new Date();
			//获取年份
			var year = date.getFullYear();
			//获取月份
			var month = date.getMonth()+1;//因为返回是0-11
			//获取天
			var day = date.getDate();
			//获取星期几
			var arr = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
			var week = arr[date.getDay()];
			//获取小时
			var hour = date.getHours();
			//获取分钟
			var minute = date.getMinutes();
			//获取秒数
			var second = date.getSeconds();

			//拼接时间字符串
			var str = year+"年"+month+"月"+day+"日"+" ("+week+")";
			
			//显示时间		
			this.html(str);
			
		}
		
	});
	
})(jQuery)