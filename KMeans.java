
import java.util.*;

import org.jfree.data.general.DefaultPieDataset;
class KMeans
{
	static int count1,count2,count3;
	static int d[];
	static int k[][];
	static int tempk[][];
	static double m[];
	static double diff[];
	static int n,p;

static int cal_diff(int a) 
{
	int temp1=0;
	for(int i=0;i<p;++i)
	{
		if(a>m[i])
			diff[i]=a-m[i];
		else
			diff[i]=m[i]-a;
	}

	int val=0;
	double temp=diff[0];
	for(int i=0;i<p;++i)
	{
		if(diff[i]<temp)
		{
			temp=diff[i];
			val=i;
		}
	}
return val;
}

static void cal_mean() 
{
	for(int i=0;i<p;++i)
	m[i]=0; // initializing means to 0
	int cnt=0;
	for(int i=0;i<p;++i)
	{
		cnt=0;
		
		for(int j=0;j<n-1;++j)
		{
			if(k[i][j]!=-1)
			{
				m[i]+=k[i][j];
				++cnt;
			}	
		}
		m[i]=m[i]/cnt;
	}
}


static int check1() 
{
	for(int i=0;i<p;++i)
	for(int j=0;j<n;++j)	
	
		if(tempk[i][j]!=k[i][j])
		{
			return 0;
		}
			return 1;
}


public  void process(int data[])
{
	p=3;

	System.out.println("Enter the number of elements ");
	n=data.length;
	d=new int[n];
	d=data;
	k=new int[p][n];
	tempk=new int[p][n];
	m=new double[p];
	diff=new double[p];

	for(int i=0;i<p;++i)
		m[i]=d[i];

		int temp=0;
		int flag=0;
	do
	{
		for(int i=0;i<p;++i)
		for(int j=0;j<n;++j)
		{
			k[i][j]=-1;	
		}
	
		for(int i=0;i<n;++i) 
		{
			temp=cal_diff(d[i]);
			
			if(temp==0)
				k[temp][count1++]=d[i];
			else if(temp==1)
				k[temp][count2++]=d[i];
			else if(temp==2)
				k[temp][count3++]=d[i]; 
		}

		cal_mean(); 
		flag=check1(); 
		
		if(flag!=1)


		for(int i=0;i<p;++i)
		for(int j=0;j<n;++j)
			tempk[i][j]=k[i][j];

		System.out.println("\n\nAt this step");
		System.out.println("\nValue of clusters");

		for(int i=0;i<p;++i)
		{
			System.out.print("K"+(i+1)+"{ ");
			
			for(int j=0;k[i][j]!=-1 && j<n-1;++j)
				System.out.print(k[i][j]+" ");
				System.out.println("}");
		}
		
		System.out.println("\nValue of m ");
		for(int i=0;i<p;++i)
			System.out.print("m"+(i+1)+"="+m[i]+"  ");
			count1=0;count2=0;count3=0;
	
	}while(flag==0);

	DefaultPieDataset dataset = new DefaultPieDataset( );
	
	System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
	for(int i=0;i<p;++i)
	{
		System.out.print("K"+(i+1)+"{ ");
		
		for(int j=0;k[i][j]!=-1 && j<n-1;++j) {
			System.out.print(k[i][j]+" ");
			if(i==0) {
				if(k[i][j]!=0)
					dataset.setValue("Low", k[i][j]);
			}
			if(i==1) {
				if(k[i][j]!=0)
					dataset.setValue("Medium", k[i][j]);
			}
			if(i==2) {
				if(k[i][j]!=0)
					dataset.setValue("High", k[i][j]);
			}
		}
			System.out.println("}");
	}
	ScatterAdd demo = new ScatterAdd("Clustering using K-means",k);
    demo.pack();
    demo.setLocationRelativeTo(null);
    demo.setVisible(true);
    PieChart_AWT demo1 = new PieChart_AWT( "Cluster",dataset,"Cluster" );  
    demo1.setSize( 560 , 367 );
    demo1.setVisible( true );
}
}

