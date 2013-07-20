package aurora.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import aurora.entity.Cluster;

@Component
public class ClusterService {
	public List<Cluster> clusterList() {
		List<Cluster> clusterList = new ArrayList<Cluster>();
		int i;
		for (i = 0; i < 10; i++) {
			Cluster cluster = new Cluster();
			cluster.setId(i + 1);
			cluster.setLastUpdateDate(new Date(System.currentTimeMillis()));
			cluster.setName("Cluster-" + i);
			clusterList.add(cluster);
		}
		return clusterList;
	}
}