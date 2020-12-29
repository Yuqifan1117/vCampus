package vcampus.server.socket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.management.Query;
import javax.swing.JOptionPane;

import vcampus.server.dao.*;
import vcampus.server.biz.*;
import vcampus.vo.*;

public class ServerSocketThread extends Thread {

	private Socket clientSocket;
	public static Query allQueries = new Query();

	public ServerSocketThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.clientSocket = socket;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream message = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			Request object = (Request) message.readObject();
			System.out.println("已接收到客户端连接 " + ",当前客户端ip为：" + clientSocket.getInetAddress().getHostAddress());
			System.out.println(String.valueOf(object.getRequest_ID()));
			Request serverResponse = new Request();
			serverResponse.setIsHandled(true);
			serverResponse.setCheckResult(false);
			// JOptionPane.showMessageDialog(null, , "【get request】",
			// JOptionPane.INFORMATION_MESSAGE);

			try {

				switch (object.getRequest_ID()) {
				// 鐢ㄦ埛绠＄悊
				case (100):// 濞夈劌鍞�
					try {
						AdminServiceDaoImpl Admin100 = new AdminServiceDaoImpl();
						StudentServiceDaoImpl Student100 = new StudentServiceDaoImpl();
						TeacherServiceDaoImpl Teacher100 = new TeacherServiceDaoImpl();
						if (object.getRequest_type() == 0) {
							Admin100.register(object.get_admin().getAdminID(), object.get_admin().getPassword());
							serverResponse.setIsHandled(true);
						}
						if (object.getRequest_type() == 1 || object.getRequest_type() == 2) {

							if (serverResponse.getRequest_type() == 1) {
								Student100.register(object.get_student().getName(), object.get_student().getPassword());
								serverResponse.setIsHandled(true);
							}
							if (serverResponse.getRequest_type() == 2) {
								Teacher100.register(serverResponse.get_teacher().getName(),
										serverResponse.get_teacher().getPassword());
								serverResponse.setIsHandled(true);
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

//				case (101):// 閻ц缍�
//					try {
//						AdminServiceDaoImpl Admin101 = new AdminServiceDaoImpl();
//						StudentServiceDaoImpl Student101 = new StudentServiceDaoImpl();
//						TeacherServiceDaoImpl Teacher101 = new TeacherServiceDaoImpl();
//						if (object.getRequest_type() == 0) {
//							if (Admin101.login(serverResponse.get_admin().getAdminID(),
//									serverResponse.get_admin().getPassword()) != null)
//								serverResponse.setCheckResult(true);
//						}
//						if (object.getRequest_type() == 1 || object.getRequest_type() == 2) {
//							if (object.getRequest_type() == 1)
//								if (Student101.login(serverResponse.get_student().getName(),
//										serverResponse.get_student().getPassword()) != null)
//									serverResponse.setCheckResult(true);
//							if (object.getRequest_type() == 2)
//								if (Teacher101.login(serverResponse.get_teacher().getName(),
//										serverResponse.get_teacher().getPassword()) != null)
//									serverResponse.setCheckResult(true);
//						}
//					} catch (Exception e) {
//						System.out.println(e);
//					}
//					break;
				case (101):// 閻ц缍�
					try {
						AdminServiceDaoImpl Admin101 = new AdminServiceDaoImpl();
						StudentServiceDaoImpl Student101 = new StudentServiceDaoImpl();
						TeacherServiceDaoImpl Teacher101 = new TeacherServiceDaoImpl();
						System.out.println("try");
						if (object.getRequest_type() == 0) {
							if (Admin101.login(serverResponse.get_admin().getAdminID(),
									serverResponse.get_admin().getPassword()) != null)
								serverResponse.setCheckResult(true);
						}
						if (object.getRequest_type() == 1 || object.getRequest_type() == 2) {
							System.out.println(111);
							if (object.getRequest_type() == 1) {
								System.out.println("sssssssssss");
								if (Student101.login("1000","546345"/*
														 * serverResponse.get_student().getId(),
														 * serverResponse.get_student().getPassword()
														 */) != null) {
									
									serverResponse.setCheckResult(true);
									System.out.println("student");
									try {
									System.out.println(serverResponse.get_student().getId());
									}catch(NullPointerException e){
										System.out.println(e);
									}
								}
							}
							if (object.getRequest_type() == 2)
								if (Teacher101.login("101","3252435"/*
														 * serverResponse.get_teacher().getId(),
														 * serverResponse.get_teacher().getPassword()
														 */) != null) {
									serverResponse.setCheckResult(true);
									System.out.println("teacher");
								}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				case (102):// 閺囧瓨鏌婄�靛棛鐖�
					try {
						AdminServiceDaoImpl Admin102 = new AdminServiceDaoImpl();
						StudentServiceDaoImpl Student102 = new StudentServiceDaoImpl();
						TeacherServiceDaoImpl Teacher102 = new TeacherServiceDaoImpl();
						if (object.getRequest_type() == 0) {
							Admin102.updatePassword(object.get_admin().getAdminID(), object.get_admin().getPassword());
							serverResponse.setIsHandled(true);
						}
						if (object.getRequest_type() == 1 || object.getRequest_type() == 2) {

							if (serverResponse.getRequest_type() == 1) {
								Student102.updatePassword(object.get_student().getName(),
										object.get_student().getPassword());
								serverResponse.setIsHandled(true);
							}
							if (serverResponse.getRequest_type() == 2) {
								Teacher102.updatePassword(object.get_teacher().getName(),
										object.get_teacher().getPassword());
								serverResponse.setIsHandled(true);
							}

						}
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (103):// 閻ц鍤�
					break;
				case (104):// 濞夈劑鏀�
					try {
						AdminServiceDaoImpl Admin104 = new AdminServiceDaoImpl();
						StudentServiceDaoImpl Student104 = new StudentServiceDaoImpl();
						TeacherServiceDaoImpl Teacher104 = new TeacherServiceDaoImpl();
						if (object.getRequest_type() == 0) {
							Admin104.destroy(object.get_admin().getAdminID());
							serverResponse.setIsHandled(true);

						}
						if (object.getRequest_type() == 1 || object.getRequest_type() == 2) {

							if (serverResponse.getRequest_type() == 1) {
								Student104.register(serverResponse.get_student().getName(),
										serverResponse.get_student().getPassword());
								serverResponse.setIsHandled(true);
							}
							if (serverResponse.getRequest_type() == 2) {
								Teacher104.register(serverResponse.get_teacher().getName(),
										serverResponse.get_teacher().getPassword());
								serverResponse.setIsHandled(true);
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
//                case (105)://缁狅紕鎮婇崨锟�
//                	try {
//                		AdminServiceDaoImpl Admin105=new AdminServiceDaoImpl();
//                	Admin105.destroy(object.get_admin().getAdminID());
//                	serverResponse.setIsHandled(true);
//                	}
//                	catch(Exception e)
//                	{
//                	System.out.println(e);
//                	}
//                	break;
				case (105):// 缁狅紕鎮婇崨锟�
					try {
						AdminServiceDaoImpl Admin105 = new AdminServiceDaoImpl();
						if (object.getRequest_type() == 1) {
							Admin105.destroy(object.get_student().getId());
						} else {
							Admin105.destroy(object.get_teacher().getId());
						}
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				// 鐎涳妇鏁撶�涳妇鐫勭粻锛勬倞

				case (200):// 婢х偛濮炵�涳妇鐫�
					try {
						StudentServiceDaoImpl Student200 = new StudentServiceDaoImpl();
						Student200.updateStudentInfo(object.get_student());
						serverResponse.setIsHandled(true);

					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (201):// 閸掔娀娅庣�涳妇鐫�
					try {
						StudentServiceDaoImpl Student201 = new StudentServiceDaoImpl();
						Student201.updateStudentInfo(object.get_student());
						serverResponse.setIsHandled(true);

					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (202):// 修改学籍
					try {
						StudentServiceDaoImpl Student202 = new StudentServiceDaoImpl();
						Student202.updateStudentInfo(object.get_student());
						serverResponse.setIsHandled(true);

					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (203):// 閺屻儲澹樼�涳妇鐫�
					try {
						StudentServiceDaoImpl Student203 = new StudentServiceDaoImpl();
						serverResponse.set_student(Student203.findByUserID(object.get_student().getId()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);

					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (204):// 查找全部学籍
					try {
						AdminDaoImpl admin204 = new AdminDaoImpl();
						serverResponse.set_studentList(admin204.queryAllStudent());
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (205):// 学号查询
					AdminDaoImpl admin205 = new AdminDaoImpl();
					String temp = object.get_student().getId();
					System.out.println(temp);
					serverResponse.set_studentList(admin205.queryStudentByStudentID(temp));
					serverResponse.setIsHandled(true);
					serverResponse.setCheckResult(true);

					break;
				case (206):// 学院查询
					try {
						AdminDaoImpl admin206 = new AdminDaoImpl();
						serverResponse
								.set_studentList(admin206.queryStudentByAcademy(object.get_student().getAcademy()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (207):// 删除教师职务
					try {
						TeacherDaoImpl teacher207 = new TeacherDaoImpl();
						teacher207.updateSelfInformation(object.get_teacher());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (208):// 修改教师职务
					try {
						TeacherDaoImpl teacher208 = new TeacherDaoImpl();
						teacher208.updateSelfInformation(object.get_teacher());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (209):// 查找指定教师职务
					try {
						TeacherDaoImpl teacher209 = new TeacherDaoImpl();
						serverResponse.set_teacher(teacher209.findByID(object.get_teacher().getId()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (210):// 全部查询
					try {
						AdminDaoImpl admin210 = new AdminDaoImpl();
						serverResponse.set_teacherList(admin210.queryAllTeacher());
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (211):// 教师编号查询
					try {
						TeacherDaoImpl teacher211 = new TeacherDaoImpl();
						serverResponse.set_teacher(teacher211.findByID(object.get_teacher().getId()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (212):// 职称查询
					try {
						AdminDaoImpl admin212 = new AdminDaoImpl();
						serverResponse.set_teacherList(admin212
								.queryTeacherByWorkplaceProfessionalTitle(object.get_teacher().getProfessionalTitle()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (213):// 所属机构查询
					try {
						AdminDaoImpl admin213 = new AdminDaoImpl();
						serverResponse
								.set_teacherList(admin213.queryTeacherByWorkplace(object.get_teacher().getWorkplace()));
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

//                case (200)://婢х偛濮炵�涳妇鐫�
//                	try {
//                		StudentServiceDaoImpl Student200=new StudentServiceDaoImpl();
//                		Student200.updateStudentInfo(object.get_student());
//                		serverResponse.setIsHandled(true);
//                		
//                	}
//                	catch(Exception e)
//                	{
//                	System.out.println(e);
//                	}
//                	break;
//                case (201)://閸掔娀娅庣�涳妇鐫�
//                	try {
//                		StudentServiceDaoImpl Student201=new StudentServiceDaoImpl();
//                		Student201.updateStudentInfo(null);
//                		serverResponse.setIsHandled(true);
//                		
//                	}
//                	catch(Exception e)
//                	{
//                	System.out.println(e);
//                	}
//                	break;
//                	case(202)://修改学籍
//                	try {
//                		StudentServiceDaoImpl Student202=new StudentServiceDaoImpl();
//                		Student202.updateStudentInfo(object.get_student());
//                		serverResponse.setIsHandled(true);
//                		
//                	}
//                    catch(Exception e)
//            	    {
//            	        System.out.println(e);
//            	    }
//            	    break;     
//                case (203)://閺屻儲澹樼�涳妇鐫�
//                	try {
//                		StudentServiceDaoImpl Student203=new StudentServiceDaoImpl();
//                		Student203.findByUserID(object.get_student().getStudentID());
//                		serverResponse.setIsHandled(true);
//                	}
//                	catch(Exception e)
//                	{
//                	System.out.println(e);
//                	}
//                	break;
//                case(204)://查找全部学籍
//                	try {
//                		AdminDaoImpl admin204=new AdminDaoImpl();
//                		serverResponse.set_studentList(admin204.queryAllStudent());
//                		serverResponse.setIsHandled(true);
//                	}
//                    catch(Exception e)
//            	    {
//            	        System.out.println(e);
//            	    }
//            	    break;
//                case(205)://学号查询
//                    try {
//                        AdminDaoImpl admin205=new AdminDaoImpl();
//                     	serverResponse.set_studentList(admin205.queryStudentByStudentID(object.get_student().getId()));
//                     	serverResponse.setIsHandled(true);
//                        	 
//                         }
//                     catch(Exception e)
//        	           {
//                 	        System.out.println(e);
//                 	    }
//                 	    break;
//                case(206)://学院查询
//                    try {
//                   	    AdminDaoImpl admin206=new AdminDaoImpl();
//                		serverResponse.set_studentList(admin206.queryStudentByAcademy(object.get_student().getAcademy()));
//                		serverResponse.setIsHandled(true);
//                   	 
//                    }
//                    catch(Exception e)
//   	                {
//            	        System.out.println(e);
//            	    }
//            	    break;
//                case(207)://删除教师职务
//                	try {
//                		TeacherDaoImpl teacher207=new TeacherDaoImpl();
//                		teacher207.updateSelfInformation(object.get_teacher());
//                		serverResponse.setIsHandled(true);
//                	}
//            	    catch(Exception e) {
//            	    	System.out.println(e);
//            	    }
//                break;
//                case(208)://修改教师职务
//                	try {
//                		TeacherDaoImpl teacher208=new TeacherDaoImpl();
//                		teacher208.updateSelfInformation(object.get_teacher());
//                		serverResponse.setIsHandled(true);
//                	}
//                    catch(Exception e) {
//        	    	System.out.println(e);
//        	        }
//                break;
//                case(209)://查找指定教师职务
//                	try {
//                		TeacherDaoImpl teacher209=new TeacherDaoImpl();
//                		serverResponse.set_teacher(teacher209.findByID(object.get_teacher().getId()));
//                		serverResponse.setIsHandled(true);
//                	}
//                    catch(Exception e) {
//        	    	System.out.println(e);
//        	        }
//                break;
//                case(210)://全部查询
//                	try {
//                		AdminDaoImpl admin210=new AdminDaoImpl();
//                		serverResponse.set_teacherList(admin210.queryAllTeacher());
//                		serverResponse.setIsHandled(true);
//                   	 
//                    }
//                    catch(Exception e)
//   	                {
//            	        System.out.println(e);
//            	    }
//            	    break;
//                case(211)://教师编号查询
//                	try {
//                		TeacherDaoImpl teacher211=new TeacherDaoImpl();
//                		serverResponse.set_teacher(teacher211.findByID(object.get_teacher().getId()));
//                		serverResponse.setIsHandled(true);
//                    }
//                    catch(Exception e)
//   	                {
//            	        System.out.println(e);
//            	    }
//            	    break;
//                case(212)://职称查询
//                	try {
//                		AdminDaoImpl admin212=new AdminDaoImpl();
//                		serverResponse.set_teacherList(admin212.queryTeacherByWorkplaceProfessionalTitle(object.get_teacher().getProfessionalTitle()));
//                		serverResponse.setIsHandled(true);
//                   	 
//                    }
//                    catch(Exception e)
//   	                {
//            	        System.out.println(e);
//            	    }
//            	    break;
//                case(213)://所属机构查询
//                	try {
//                		AdminDaoImpl admin213=new AdminDaoImpl();
//                		serverResponse.set_teacherList(admin213.queryTeacherByWorkplace(object.get_teacher().getWorkplace()));
//                		serverResponse.setIsHandled(true);
//                   	 
//                    }
//                    catch(Exception e)
//   	                {
//            	        System.out.println(e);
//            	    }
//            	    break;
				// 閫夎绯荤粺
				case (300):
					try {

						System.out.println("s");
						StudentServiceDaoImpl Student300 = new StudentServiceDaoImpl();
						System.out.println("w");
						ArrayList<CourseSelectNDrop> temp300 = Student300
								.findAllChosenCourses(object.get_student().getStudentID());
						CopyOnWriteArrayList<Course> result300 = new CopyOnWriteArrayList();
						for (CourseSelectNDrop in : temp300) {
							Course tempCourse = Student300.findCourseInformation(in.getCourseID());
							result300.add(tempCourse);
						}

						serverResponse.set_courseList(result300);
						System.out.println("q");
//                		serverResponse.setRequest_ID(54321);
						System.out.println("qws");
						serverResponse.setIsHandled(true);
						System.out.println("here it is");
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				case (301):// 閫夎
					try {
						StudentServiceDaoImpl Student301 = new StudentServiceDaoImpl();
						Student301.addCourse(object.get_student().getId(), object.get_course().getCourseID());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (302):// 閫�璇�
					try {
						StudentServiceDaoImpl Student302 = new StudentServiceDaoImpl();
						Student302.deleteCourse(object.get_student().getId(), object.get_course().getCourseID());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (303):// 鏌ョ湅宸查�夎绋�
					try {
						StudentServiceDaoImpl Student303 = new StudentServiceDaoImpl();
						Student303.findAllChosenCourses(object.get_student().getId());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (304):// 绠＄悊鍛樺姞璇�
					try {
						AdminServiceDaoImpl Admin304 = new AdminServiceDaoImpl();
						Admin304.addCoursebyAdmin(object.get_course());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (305):// 绠＄悊鍛樺垹璇�
					try {
						AdminServiceDaoImpl Admin305 = new AdminServiceDaoImpl();
						Admin305.deleteCoursebyAdmin(object.get_course().getCourseID());
						serverResponse.setIsHandled(true);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case (306):

					break;

				case (400):// Boolean AddBook(Book book);
					try {
						LibraryDaoImpl Dao400 = new LibraryDaoImpl();
						if (Dao400.addBookByAdmin(object.get_book()))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (401):// Boolean DeleteBook(Book book)
					try {
						LibraryDaoImpl Dao401 = new LibraryDaoImpl();
						if (Dao401.deleteBookByAdmin(object.get_book().getBookID()))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (402):// Book SearchBook(String bookname,String Writer)
					try {

						LibraryDaoImpl Dao402 = new LibraryDaoImpl();
						ArrayList<Book> tmresultset = Dao402.queryBook(object.get_book().getBookName());
						serverResponse.set_bookList(tmresultset);
						serverResponse.setCheckResult(true);
						break;

					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (403):// CopyOnWriteArrayList<Book> showbook()
					try {
						LibraryDaoImpl Dao403 = new LibraryDaoImpl();
						serverResponse.set_bookList(Dao403.queryAllBook());
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (404):// Boolen Borrow(Book book, int id)
					try {
						LibraryDaoImpl Dao404 = new LibraryDaoImpl();
						if (Dao404.borrowBook(object.get_borrowNreturn()))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (405):// Boolean Send(Book book, int id)
					try {
						LibraryDaoImpl Dao405 = new LibraryDaoImpl();
						if (Dao405.returnBook(object.get_borrowNreturn()))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				// shop
				case (500):// Boolean AddGoods(Goods goods)
					try {
						ShopDaoImpl Dao500 = new ShopDaoImpl();
						if (Dao500.addProductByAdmin(object.get_product()))
							;
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (501):// Boolean DeleteGoods(Goods goods)
					try {
						ShopDaoImpl Dao501 = new ShopDaoImpl();
						if (Dao501.deleteProductByAdmin(object.get_product().getProductID()))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (502):// Book SearchGoods(String goodsId,String goodsName)
					try {
						ShopDaoImpl Dao502 = new ShopDaoImpl();
						ProductInformation Products = Dao502
								.queryProductInformation(object.get_product().getProductID());
						serverResponse.set_product(Products);
						serverResponse.setCheckResult(true);

					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

				case (503):// CopyOnWriteArrayList<Goods> showgoods()
					try {
						ShopDaoImpl Dao503 = new ShopDaoImpl();
						serverResponse.set_productList(Dao503.queryAllProduct());
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (504):// Boolean Purchase(Goods goods)
					try {
						ShopDaoImpl Dao504 = new ShopDaoImpl();
						int temptype = object.getRequest_type() == 1 ? 0 : 1;
						if (Dao504.buyProduct(object.get_productPurchase(), temptype))
							serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;

//            	//Library
//		            case(400)://Boolean AddBook(Book book);
//		            	try {
//		            		LibraryDaoImpl Dao400=new LibraryDaoImpl();
//			            	if(Dao400.addBookByAdmin(object.get_book()))
//							serverResponse.setCheckResult(true);
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//						
//		            case(401)://Boolean DeleteBook(Book book)
//		            	try {
//		            		LibraryDaoImpl Dao401=new LibraryDaoImpl();
//		            		if(Dao401.deleteBookByAdmin(object.get_book().getBookID()))
//							serverResponse.setCheckResult(true);
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//								            	
//		            case(402)://Book SearchBook(String bookname,String Writer)
//		            	try {
//		            		LibraryDaoImpl Dao402=new LibraryDaoImpl();
//		            		ArrayList<Book>tmresultset=Dao402.queryBook(object.get_book().getBookName());
//		            		for(Book in:tmresultset) {
//		            			if(in.getAuthor().equals(object.get_book().getBookName()))
//		            			{
//		            				serverResponse.set_book(in);
//		            				serverResponse.setCheckResult(true);
//		            				break;
//		            			}
//		            		}
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//		            	
//		            case(403)://CopyOnWriteArrayList<Book> showbook()
//		            	try {
//		            		LibraryDaoImpl Dao403=new LibraryDaoImpl();
//		            		serverResponse.set_bookList(Dao403.queryAllBook());
//			            	serverResponse.setCheckResult(true);
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//		            
//		            case(404)://Boolen Borrow(Book book, int id)
//		            	try {
//		            		LibraryDaoImpl Dao404=new LibraryDaoImpl();
//		            		if(Dao404.borrowBook(object.get_borrowNreturn()))
//			            	serverResponse.setCheckResult(true);
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//		            	
//		            case(405)://Boolean Send(Book book, int id)
//		            	try {
//		            		LibraryDaoImpl Dao405=new LibraryDaoImpl();
//		            		if(Dao405.returnBook(object.get_borrowNreturn()))
//			            	serverResponse.setCheckResult(true);
//						}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//		            	break;
//		            
//		            //shop
//		            case(500)://Boolean AddGoods(Goods goods)
//		            	try {
//		            		ShopDaoImpl Dao500=new ShopDaoImpl();
//		            		if(Dao500.addProductByAdmin(object.get_product()));
//		            		serverResponse.setCheckResult(true);
//		            	}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//
//	            	break;
//		            case(501)://Boolean DeleteGoods(Goods goods)
//		            	try {
//		            		ShopDaoImpl Dao501=new ShopDaoImpl();
//		            		if(Dao501.deleteProductByAdmin(object.get_product().getProductID()))
//		            		serverResponse.setCheckResult(true);
//		            	}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//
//	            	break;
//		            case(502)://Book SearchGoods(String goodsId,String goodsName)
//		            	try {
//		            		ShopDaoImpl Dao502=new ShopDaoImpl();
//		            		ArrayList<ProductInformation>Products=new ArrayList();
//		            		if((Products=Dao502.queryAllProduct()) != null) {
//		            			for(ProductInformation in:Products) {
//		            				if((in.getProductID().equals(object.get_product().getProductID()))&&
//		            						(in.getProductName().equals(object.get_product().getProductName())))
//		            				{
//		            					serverResponse.set_product(in);
//		            				}
//		            			}
//		            		}
//		            		if(Dao502.addProductByAdmin(object.get_product()));
//		            		serverResponse.setCheckResult(true);
//		            	}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//
//	            	break;
//		            case(503)://CopyOnWriteArrayList<Goods> showgoods()
//		            	try {
//		            		ShopDaoImpl Dao503=new ShopDaoImpl();
//            				serverResponse.set_productList(Dao503.queryAllProduct());
//		            	}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//
//	            	break;
//		            case(504)://Boolean Purchase(Goods goods)
//		            	try {
//		            		ShopDaoImpl Dao504=new ShopDaoImpl();
//		            		int temptype=object.getRequest_type()==1?0:1;
//		            		if(Dao504.buyProduct(object.get_productPurchase(), temptype))
//		            		serverResponse.setCheckResult(true);
//		            	}catch(Exception e) {
//		            		System.out.println(e);
//		            		serverResponse.setCheckResult(false);
//		            	}
//
//	            	break;

				case (600):// double queryAccountByUserID(String userID)
					try {
						BankDaoImpl Dao600 = new BankDaoImpl();
						double newAccount = Dao600
								.queryAccountByUserID(object.getRequest_type() == 1 ? object.get_student().getId()
										: object.get_teacher().getId());
						if (object.getRequest_type() == 1) {
							Student tempStu600 = new Student();
							tempStu600.setAccount(newAccount);
							serverResponse.set_student(tempStu600);
						} else {
							Teacher tempTea600 = new Teacher();
							tempTea600.setAccount(newAccount);
							serverResponse.set_teacher(tempTea600);
						}
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (601):// double queryMoneyByUserID(String userID)
					try {
						BankDaoImpl Dao601 = new BankDaoImpl();
						double newAccount = Dao601
								.queryMoneyByUserID(object.getRequest_type() == 1 ? object.get_student().getId()
										: object.get_teacher().getId());
						if (object.getRequest_type() == 1) {
							Student tempStu601 = new Student();
							tempStu601.setMoney(newAccount);
							serverResponse.set_student(tempStu601);
						} else {
							Teacher tempTea601 = new Teacher();
							tempTea601.setMoney(newAccount);
							serverResponse.set_teacher(tempTea601);
						}
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (602):// boolean rechargeByBankAccount(Account charge_account)
					try {
						BankDaoImpl Dao602 = new BankDaoImpl();
						Dao602.rechargeByBankAccount(object.get_account());
						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (603):// ArrayList<Account> queryRechargeInformation(String userID)
					try {
						BankDaoImpl Dao603 = new BankDaoImpl();
						Dao603.queryRechargeInformation(object.getRequest_type() == 1 ? object.get_student().getId()
								: object.get_teacher().getId());

						serverResponse.setIsHandled(true);
						serverResponse.setCheckResult(true);
					} catch (Exception e) {
						System.out.println(e);
						serverResponse.setCheckResult(false);
					}
					break;
				case (913): {
					System.out.println("swq");
					serverResponse.setRequest_ID(523);
				}

					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("wrong in process of" + clientSocket.getInetAddress().getHostAddress());
				System.out.println(String.valueOf(object.getRequest_ID()));

			}
			ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
			response.writeObject(serverResponse);
			response.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
