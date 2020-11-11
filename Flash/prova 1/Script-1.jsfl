package {
	import flash.display.*;
	import flash.events.*
	
	public class QuadradoInterativo extends MovieClip {
		
		public function QuadradoInterativo(iniX,iniY) {
			this.x=iniX;
			this.y=iniY;
			this.addEventListener(MouseEvent.MOUSE_DOWN,mousepressionado);
		}
		public function mousepressionado (event:MouseEvent){
			this.rotation =+5;
		}
			
	}
}