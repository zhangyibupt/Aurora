package aurora.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aurora.entity.Cluster;
import aurora.service.ClusterService;
import aurora.ui.model.ClusterModel;

@Controller
public class ClusterController {
	private ClusterService clusterService;

	private ClusterService getClusterService() {
		return clusterService;
	}

	@Autowired
	private void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}

	@RequestMapping("/cluster/list")
	public ModelAndView list() {
		List<Cluster> list = this.getClusterService().clusterList();
		List<ClusterModel> clusterModelList = new ArrayList<ClusterModel>();
		for (Cluster cluster : list) {
			ClusterModel clusterModel = new ClusterModel();
			clusterModel.setId(cluster.getId());
			clusterModel.setLastUpdateDate(cluster.getLastUpdateDate());
			clusterModel.setName(cluster.getName());
			clusterModelList.add(clusterModel);
		}
		return new ModelAndView("clusterList", "clusterList", clusterModelList);
	}
}
