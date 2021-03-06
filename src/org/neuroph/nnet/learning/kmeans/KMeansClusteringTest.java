package org.neuroph.nnet.learning.kmeans;

import java.util.Arrays;

import org.neuroph.core.data.DataSet;

public class KMeansClusteringTest {
	
	
	public static void runKMeans(){
		int k = 3;
		String filePath = "E:\\java\\neuroph-core\\src\\main\\java\\org\\neuroph\\nnet\\learning\\kmeans\\iris.arff";
		int inputsCount =  4; 
		int outputsCount = 0;
		String delimiter = ",";
		boolean loadColumnNames = false;
		DataSet dataSet = DataSet.createFromFile(filePath, inputsCount, outputsCount, delimiter, loadColumnNames);
		dataSet.toString();
		KMeansClustering kmeans = new KMeansClustering(dataSet,k);
		kmeans.doClustering();
		Cluster[] clusters= kmeans.getClusters();
		for(Cluster cluster:clusters){
			KVector centroid = cluster.getCentroid();
			
			System.out.println(centroid.toString());
		}
		
		for (Cluster cluster : clusters) { // for each cluster
			KVector centroid = cluster.getCentroid();
                System.out.println(Arrays.toString(centroid.getValues()));  // and set new centroid to avg sum
            }                                 
        }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runKMeans();
	}
}
