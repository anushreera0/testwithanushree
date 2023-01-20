/**
 * 
 */

		function istDate() {
			var noofday = 0; 
			var currentTime = new Date(); 
			currentTime.setDate(currentTime.getDate()+noofday); 
			var currentOffset = currentTime.getTimezoneOffset(); 
			var ISTOffset = 330; 
			var ISTTime = new Date(currentTime.getTime() + (ISTOffset + currentOffset)*60000); 
			var date = ISTTime.getDate(); 
			if (date < 10) {
				var date = '0'+date;
				}
			var month = ISTTime.getMonth(); 
			var year = ISTTime.getFullYear(); 
			var months = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'); 
			return months[month]+ '/'+date+ '/' +year; 
			} 
			