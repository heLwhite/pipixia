		
		var ws=null;
		function subOpen(object)
		{
			var target = "ws://"+window.location.host+"/"+object.address;
			if ('WebSocket' in window) {
                ws = new WebSocket(target);
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(target);
            } else {
                alert('WebSocket is not supported by this browser.');
                return;
            }
				ws.onopen=function()
				{
					console.info("webSocket通道建立成功！！！");  
	 		    };
			
	 		    ws.onmessage=function(even)
	 		    {
	 		    	object.message(even);
	 		    };
	 	};
	 	
	 	function onsubSend(data,fn)
	 	{
	 		ws.send(data);
	 		fn();
	 	}