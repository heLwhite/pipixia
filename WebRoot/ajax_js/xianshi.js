window.onload = function()
{
	var btn =document .getElementById("btn");
	btn.onclick = function()
	{
		ajax(
				{
					url:"login.action",
					type:"json",
					roolback:function(data)
					{
						document.getElementById("").innerHTML=data;
					}
				}
		
		);
	}
}