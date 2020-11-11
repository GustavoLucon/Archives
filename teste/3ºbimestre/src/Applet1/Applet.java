package Applet1;

public class Applet {

	public static void main(String[] args) {
	for (int i = 0 ; i <= 9 ; i++)
	{
		for (int j = 0 ; j <= 9 ; j++)
		{
			for (int k = 0 ; k <= 9 ; k++)
			{
				for (int l = 0 ; l <= 9 ; l++)
				{
					if(i != j && i != k && i != l && j != k && j != l && l != k) 
					{
						System.out.println(i+ "" + j +"" + k +"" + l );
					}
				}
			}
		}
	}

	}

}
