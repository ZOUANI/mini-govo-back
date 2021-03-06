package ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.service.facade.OrderLineService;
import ma.zs.generated.ws.rest.provided.converter.OrderLineConverter;
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;

@Api("Manages orderLine services")
@RestController
@RequestMapping("generated/orderLine")
public class OrderLineRest {

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private OrderLineConverter orderLineConverter;

    @ApiOperation("Saves the specified orderLine")
    @PostMapping("/")
    public OrderLineVo save(@RequestBody OrderLineVo orderLineVo) {
        OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
        orderLine = orderLineService.save(orderLine);
        return orderLineConverter.toVo(orderLine);
    }

    @ApiOperation("Delete the specified orderLine")
    @DeleteMapping("/")
    public int delete(@RequestBody OrderLineVo orderLineVo) {
        OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
        return orderLineService.delete(orderLine);
    }

    @ApiOperation("Updates the specified orderLine")
    @PutMapping("/")
    public OrderLineVo update(@RequestBody OrderLineVo orderLineVo) {
        OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
        orderLine = orderLineService.update(orderLine);
        return orderLineConverter.toVo(orderLine);
    }
    
    @ApiOperation("Finds Affected Tasks of a collaborator")
	@GetMapping("/collaboratorAffectedTasks/id/{id}")
	public List<OrderLineVo> findByCollaboratorIdAndDateAcceptationCollaboratorIsNull(@PathVariable Long id){
		return orderLineConverter.toVo(orderLineService.findByCollaboratorIdAndDateAcceptationCollaboratorIsNull(id));
	}
	
	
	@ApiOperation("Finds Tasks of a collaborator")
	@GetMapping("/collaboratorTasks/id/{id}")
	public List<OrderLineVo> findByCollaboratorIdAndDateAcceptationCollaboratorIsNotNull(@PathVariable Long id){
		return orderLineConverter.toVo(orderLineService.findByCollaboratorIdAndDateAcceptationCollaboratorIsNotNull(id));
	}
	
	@ApiOperation("ignorer tache")
	@PutMapping("/ignorerTache/id/{id}")
	public int ignorerTache(@PathVariable Long id){
//		OrderLine orderLine= orderLineConverter.toItem(orderLineVo);
	  return orderLineService.ignorerTache(id);
	}
	
	@ApiOperation("s'encharger tache")
	@PutMapping("/enchargerTache/id/{id}")
	public int enchargerTache(@PathVariable Long id){
//		OrderLine orderLine= orderLineConverter.toItem(orderLineVo);
	  return orderLineService.enchargerTache(id);
	}
	
	@ApiOperation("change task status")
	@PutMapping("/changeStatus/id/{id}/{statusId}")
	public int changeStatus(@PathVariable Long id ,@PathVariable Long statusId ){
//		OrderLine orderLine= orderLineConverter.toItem(orderLineVo);
	  return orderLineService.changeStatus(id, statusId);
	}
	

    @ApiOperation("Finds a list of all orderLines")
    @GetMapping("/")
    public List<OrderLineVo> findAll() {
        return orderLineConverter.toVo(orderLineService.findAll());
    }

    @ApiOperation("Finds a orderLine by id")
    @GetMapping("/id/{id}")
    public OrderLineVo findById(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findById(id));
    }

    @ApiOperation("Deletes a orderLine by id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        orderLineService.deleteById(id);
    }


    @ApiOperation("Finds a orderLine by code of orderStatus ")
    @GetMapping("/orderStatus /code/{code}")
    public List<OrderLineVo> findByOrderStatusCode(@PathVariable String code) {
        return orderLineConverter.toVo(orderLineService.findByOrderStatusCode(code));
    }

    @ApiOperation("Deletes a orderLine by code of orderStatus ")
    @DeleteMapping("/orderStatus /code/{code}")
    public int deleteByOrderStatusCode(@PathVariable String code) {
        return orderLineService.deleteByOrderStatusCode(code);
    }

    @ApiOperation("Finds orderLine by id of orderStatus ")
    @GetMapping("/orderStatus /id/{id}")
    public List<OrderLineVo> findByOrderStatusId(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findByOrderStatusId(id));
    }

    @ApiOperation("Deletes orderLine by id of orderStatus ")
    @DeleteMapping("/orderStatus /id/{id}")
    public int deleteByOrderStatusId(@PathVariable Long id) {
        return orderLineService.deleteByOrderStatusId(id);
    }


    @ApiOperation("Finds orderLine by id of deliveryMan")
    @GetMapping("/deliveryMan/id/{id}")
    public List<OrderLineVo> findByDeliveryManId(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findByDeliveryManId(id));
    }

    @ApiOperation("Deletes orderLine by id of deliveryMan")
    @DeleteMapping("/deliveryMan/id/{id}")
    public int deleteByDeliveryManId(@PathVariable Long id) {
        return orderLineService.deleteByDeliveryManId(id);
    }


    @ApiOperation("Finds orderLine by id of collaborator")
    @GetMapping("/collaborator/id/{id}")
    public List<OrderLineVo> findByCollaboratorId(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findByCollaboratorId(id));
    }

    @ApiOperation("Deletes orderLine by id of collaborator")
    @DeleteMapping("/collaborator/id/{id}")
    public int deleteByCollaboratorId(@PathVariable Long id) {
        return orderLineService.deleteByCollaboratorId(id);
    }

    @ApiOperation("Finds a orderLine by reference of command")
    @GetMapping("/command/reference/{reference}")
    public List<OrderLineVo> findByCommandReference(@PathVariable String reference) {
        orderLineConverter.setProduct(Boolean.TRUE);
        orderLineConverter.setCollaborator(Boolean.TRUE);
        orderLineConverter.setDeliveryMan(Boolean.TRUE);
        orderLineConverter.setOrderStatus(Boolean.TRUE);
        return orderLineConverter.toVo(orderLineService.findByCommandReference(reference));
    }

    @ApiOperation("Deletes a orderLine by reference of command")
    @DeleteMapping("/command/reference/{reference}")
    public int deleteByCommandReference(@PathVariable String reference) {
        return orderLineService.deleteByCommandReference(reference);
    }

    @ApiOperation("Finds orderLine by id of command")
    @GetMapping("/command/id/{id}")
    public List<OrderLineVo> findByCommandId(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findByCommandId(id));
    }

    @ApiOperation("Deletes orderLine by id of command")
    @DeleteMapping("/command/id/{id}")
    public int deleteByCommandId(@PathVariable Long id) {
        return orderLineService.deleteByCommandId(id);
    }

    @ApiOperation("Finds a orderLine by reference of product")
    @GetMapping("/product/reference/{reference}")
    public List<OrderLineVo> findByProductReference(@PathVariable String reference) {
        return orderLineConverter.toVo(orderLineService.findByProductReference(reference));
    }

    @ApiOperation("Deletes a orderLine by reference of product")
    @DeleteMapping("/product/reference/{reference}")
    public int deleteByProductReference(@PathVariable String reference) {
        return orderLineService.deleteByProductReference(reference);
    }

    @ApiOperation("Finds orderLine by id of product")
    @GetMapping("/product/id/{id}")
    public List<OrderLineVo> findByProductId(@PathVariable Long id) {
        return orderLineConverter.toVo(orderLineService.findByProductId(id));
    }

    @ApiOperation("Deletes orderLine by id of product")
    @DeleteMapping("/product/id/{id}")
    public int deleteByProductId(@PathVariable Long id) {
        return orderLineService.deleteByProductId(id);
    }


    @ApiOperation("Search orderLine by a specific criterion")
    @PostMapping("/search")
    public List<OrderLineVo> findByCriteria(@RequestBody OrderLineVo orderLineVo) {
        return orderLineConverter.toVo(orderLineService.findByCriteria(orderLineVo));
    }

    public OrderLineConverter getOrderLineConverter() {
        return orderLineConverter;
    }

    public void setOrderLineConverter(OrderLineConverter orderLineConverter) {
        this.orderLineConverter = orderLineConverter;
    }

    public OrderLineService getOrderLineService() {
        return orderLineService;
    }

    public void setOrderLineService(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @ApiOperation("Updates the specified orderLine")
    @PutMapping("/orderStatus")
    public OrderLineVo updateOrderStatus(@RequestBody OrderLineVo orderLineVo) {
        orderLineConverter.setProduct(Boolean.TRUE);
        orderLineConverter.setCollaborator(Boolean.TRUE);
        orderLineConverter.setDeliveryMan(Boolean.TRUE);
        orderLineConverter.setOrderStatus(Boolean.TRUE);
        OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
        orderLine = orderLineService.updateOrderStatus(orderLine);
        return orderLineConverter.toVo(orderLine);
    }

    @PutMapping("/collaborator/")
    public OrderLineVo affectCollaborator(@RequestBody OrderLineVo orderLineVo) {
        orderLineConverter.setOrderStatus(Boolean.TRUE);
        orderLineConverter.setCollaborator(Boolean.TRUE);
        OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
        orderLine = orderLineService.affectCollaborator(orderLine);
        return orderLineConverter.toVo(orderLine);
    }

}