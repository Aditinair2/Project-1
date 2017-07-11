package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDetailDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

@Controller
public class ProductController {

	@Autowired(required = true)
	private ProductDao productDAO;

	@Autowired
	private CategoryDao categoryDAO;

	@Autowired
	private SupplierDao supplierDAO;

	@Autowired
	private UserDetailDao userdetailDAO;

	private Path path;

	/*
	 * @Autowired(required=true)
	 * 
	 * @Qualifier(value="productDAO") public void setProductDAO(ProductDAO ps){
	 * this.productDAO = ps; }
	 */

	@RequestMapping(value = "/admin/product/productform", method = RequestMethod.GET)
	public String listProducts(Model model) {
		System.out.println("Hello.. I'm inside /products list");
		model.addAttribute("isAdminClickedProducts", "true");

		model.addAttribute("productList", productDAO.list());
		model.addAttribute("product", new Product());

		// model.addAttribute("Category", new Category());
		// model.addAttribute("Supplier", new Supplier());

		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());

		return "product";
	}

//	@RequestMapping("/all/product/viewproduct/{id}")
//	public String viewProduct(@PathVariable int id, Model model) {
//		Product product = productDAO.getProductById(id);
//		model.addAttribute("selectedProduct", product);
////		List<Category> categoryRecordss = categoryDAO.list();
////		model.addAttribute("categoryList", categoryRecordss);
//		return "viewproduct";
//	}

	// For add and update product both
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			HttpServletRequest request) {

		int categoryId = Integer.parseInt(request.getParameter("category"));
		int supplierId = Integer.parseInt(request.getParameter("supplier"));

		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("supplier"));

		// fetch the single category using its id

		//

		// set the category fetched suing the setCategory

		//

		// System.out.println(product.getCategory());

		// Category category = categoryDAO.getByName("Jewellery");

		Category category = categoryDAO.getCategoryById(categoryId);

		// System.out.println(category.getId() + ":" + category.getName() + ":"
		// + category.getDescription());

		Supplier supplier = supplierDAO.getSupplierByID(supplierId);

		// System.out.println(supplier.getId() + ":" + supplier.getName() + ":"
		// + supplier.getAddress());

		// model.addAttribute("Supplier", supplier);
		// model.addAttribute("Category", categoryDAO.list());
		// model.addAttribute("productlist", productDAO.list());
		// model.addAttribute("supplierList", this.supplierDAO.list());
		// model.addAttribute("categoryList", this.categoryDAO.list());

		// int newID = product.getId();
		// product.setId(newID);

		// product.setCategory(category.getId());
		// product.setSupplier(supplier.getId());

		product.setCategory(category);
		product.setSupplier(supplier);

		productDAO.saveOrUpdate(product);

		/*
		 * path="D:\\product\\image"; FileUtil.upload(path, itemImage,
		 * product.getId()+".png");
		 */

		MultipartFile itemImage = product.getItemImage();
		path = Paths.get("/Users/aditinair/git/Project_Ekart/EkartOnline/src/main/webapp/resources/images/" + product.getId() + ".png");
		System.out.println("hjhkjh");

		if (itemImage != null && !itemImage.isEmpty()) {
			try {
				System.out.println("inside try");
				itemImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed.", e);
			}
		}

		return "redirect:/admin/product/productform";

	}

	@RequestMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable("id") int id, ModelMap model) throws Exception {
		System.out.println("Hello.. I'm inside /products remove");
		try {
			productDAO.deleteProductById(id);
			model.addAttribute("message", "Successfully deleted");

			path = Paths.get("/Users/aditinair/Desktop/codes/Updated_project-master 2/EkartOnline/src/main/webapp/resources/images" + id + ".png");

			if (Files.exists(path)) {
				try {
					Files.delete(path);
					System.out.println("Image successfully deleted");
				} catch (IOException e) {
					System.out.println("Error in Image deletion");
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/products";
	}

	@RequestMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") int id, // @ModelAttribute("product")
															// Product product,
			HttpServletRequest request, Model model) {
		Product fectedProduct = productDAO.getProductById(id);
		System.out.println(fectedProduct + "*********");
//
//		request.setAttribute("product", fectedProduct);
//		System.out.println(request.getAttribute("product"));
//
//		// model.addAttribute("product", fectedProduct);
//
//		model.addAttribute("isAdminClickedEditProducts", "true");
//		System.out.println("Hello.. I'm inside /products edit");
//		model.addAttribute("Category", new Category());
//		model.addAttribute("Supplier", new Supplier());
//		model.addAttribute("supplierList", this.supplierDAO.list());
//		model.addAttribute("categoryList", this.categoryDAO.list());
//		// model.addAttribute("product", this.productDAO.getProductById(id));
//		model.addAttribute("productList", this.productDAO.list());
//
//		if ((SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)) {
//
//			User activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			if (activeUser != null) {
//				List<UserDetail> usersdetail = userdetailDAO.getAllUsers();
//				for (UserDetail u : usersdetail) {
//					if (u.getUser().getUsername().equals(activeUser.getUsername())) {
//						model.addAttribute("customer", u.getCart());
//					}
//				}
//
//			}
			Product product=productDAO.getProductById(id);
	//[product attribute - [4,'Toy','descr','mnat',7800,12,..]
	model.addAttribute("product",product);
	List<Category> categoryRecords=categoryDAO.list();
	model.addAttribute("categoryrecords",categoryRecords);
	List<Category> categoryRecordss=categoryDAO.list();
	model.addAttribute("categoryList",categoryRecordss);
	model.addAttribute("supplierList", this.supplierDAO.list());
		
		return "product";
	
}

	/*
	 * @RequestMapping("/product/get/{id}") public String
	 * getProduct(@PathVariable("id") String id, Model model) {
	 * System.out.println("get Product"); model.addAttribute("Supplier",
	 * supplier); model.addAttribute("Category", category);
	 * model.addAttribute("supplierList", this.supplierDAO.list());
	 * model.addAttribute("categoryList", this.categoryDAO.list());
	 * product=productDAO.get(id); model.addAttribute("product",product);
	 * model.addAttribute("selectedProduct",
	 * this.productDAO.getByName(product.getName()));
	 * model.addAttribute("productList", this.productDAO.list()); //return
	 * "/iindex"; return "redirect:/"; }
	 */

	@RequestMapping("/all/product/viewproduct/{id}")
	public String getSelectedProduct(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("getSelectedProduct");

		model.addAttribute("productList", this.productDAO.list());

		// redirectAttributes.addFlashAttribute("selectedProduct",
		// this.productDAO.get(id));
		model.addAttribute("selectedProduct", this.productDAO.getProductById(id));
		// model.addAttribute("categoryList", this.categoryDAO.list());
		/*if ((SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)) {

			User activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println(activeUser.getUsername());
			if (activeUser != null) {
				List<UserDetail> usersdetail = userdetailDAO.getAllUsers();
				for (UserDetail u : usersdetail) {
					if (u.getUser().getUsername().equals(activeUser.getUsername())) {
						model.addAttribute("cart", u.getCart());
						System.out.println("Testing");
					}
				}

			}
		}*/
		return "viewproduct";
	}

}
