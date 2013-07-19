package aurora.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aurora.service.ClusterService;
import aurora.ui.model.Cluster;

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
		return new ModelAndView("clusterList", "clusterList", list);
	}
}
