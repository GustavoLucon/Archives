package {
	import flash.display.*;
	import flash.events.*;
	
	public class Barra extends MovieClip {
			    var velocidade:int;
		public function Barra()
		{
		velocidade = 100;
		}
		public function baixo(event:Event){
		this.y = this.y + velocidade;
		}

		public function alto(event:Event){
		this.y = this.y - velocidade;
		}
	}
	}