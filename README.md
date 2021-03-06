# HospitalTreatmentSystem
## 医院门诊应用系统，基于Web和MySQl数据库开发。  
### 一、系统介绍  
    本系统为医院门诊应用系统，系统的功能包括：挂号、退号、医生看诊、医生开药、收费、发药等。不同身份的医院人员使用账号和密码登录系统后，能根据权限的不同对系统进行不同的操作。医生登录系统后，能进行看诊、开药的业务操作；财务人员登录系统后，能进行挂号、退号、收费的业务操作；药房人员登录系统后，能进行发药的业务操作。即该系统要能够满足患者到医院门诊就诊时的整个业务流程。  
    系统的实现遵循MVC设计模式，采用了Jquery前端开发框架和SSM服务器端开发框架，使用了Ajax技术实现页面的异步提交和局部刷新。系统具有美观合理的用户界面，以及良好的系统健壮性和浏览器兼容性。此外，本系统还使用了过滤器，以实现系统的字符编码功能和防盗链功能。  
### 二、相关技术  
(1)	技术理论：  
1、MVC设计模式  
2、前端开发技术：HTML, CSS, Javascript等  
3、服务器端开发技术：Servlet,JSP等  
2、前端开发框架：Jquery, vue.js等  
3、服务器端开发框架：SSM，包括：Spring MVC、Spring、MyBatis  
4、Ajax技术，Json数据格式  
7、过滤器  
(2)	开发方法：面向对象方法  
(3)	开发工具：Eclipse Java EE IDE for Web Developers 2018-09 (4.9.0)  
(4)	开发环境：JDK1.8、Tomcat9.0、Servlet4.0、MySQL5.7.26  
### 三、系统设计  
(1)	系统架构设计：  
    该系统采用MVC设计模式，将项目分为模型、视图和控制器三个部分。模型层再细分成Service层和DAO层，Service层负责控制事务，DAO层负责完成数据库表的CRUD操作。视图层主要是JSP，控制器控制数据流向模型对象并在数据变化时更新视图。  
(2)	功能模块划分：  
    根据业务流程和功能分析，将该系统的功能划分为：用户登录、挂号、退号、医生看诊、医生开药、收费、药房发药、费用查询这8个功能模块。  
(3)	功能模块详细设计：  
①　用户登录  
    用户输入账号和密码，点击登录按钮进行登录系统，根据登录身份的权限不同，允许使用不同的功能模块。  
②　挂号  
    如果是第一次挂号，需要填写患者的姓名，身份证号，性别，出生日期等个人基本信息，系统自动生成可用病历号；如果之前挂过号，输入患者的病历号，直接列出以上个人信息。  
    系统将自动初始化性别，挂号级别，挂号科室，挂号医生，显示在下拉列表中。科室和医生是一对多的关系，切换科室和号别，更新医生列表。根据号别切换诊费，普通号别和专家号别的费用从数据库中读取。  
    填写挂号信息完毕后，点击挂号按钮，使用JS实现表单验证，表单校验正确，提交表单，否则弹出错误提示信息，不提交表单。保存挂号信息到数据库，系统为每次挂号生成唯一的挂号ID，挂号完成将弹出成功提示。  
③　退号  
    用户输入病历号，点击搜索按钮，表格中列出当日当前病历号下的所有挂号信息。选择某一行的挂号信息，点击退号按钮，对退号操作进行校验，已经看诊的不能退号，退号成功将弹出提示框。退号后不能进行缴费，退费等后续操作。  
④　医生看诊  
    系统将在医生成功登录后，自动查找该医生当日的待诊患者和已诊患者列表，并显示在页面的左边。医生在待诊患者列表中选择某一位患者，点击“门诊病历”，填写该患者的病历信息，点击保存按钮，保存就诊信息，已就诊的患者不能进行退号操作。  
⑤　医生开药  
    医生在已诊患者列表中选择某一位患者，点击“成药处方”，填写药品的名称、数量、用法、用量等信息并点击增方，数据库自动读取药品的规格、单价等信息并显示在表格中，医生勾选表格中的药品，并点击开药按钮完成操作，系统将弹出开药成功或失败的消息提示框。  
⑥　收费  
    输入病历号，列出药品费用列表，点击列头的全选进行选中所有行，选择某些行，点击“收费结算”按钮，弹出“发票信息（交费）”消息框，填写实收金额，使用js自动计算找零金额并显示在消息框内，点击收费按钮，保存收费信息到数据库，系统将弹出收费成功或失败的提示框。  
⑦　药房发药  
    填写病历号和开药时间，点击查询按钮，将符合条件的所有药品明细显示在表格中，选择表格中的药品明细，点击发药按钮完成操作，保存发药信息到数据库，系统将弹出操作成功或失败的提示框。  
⑧　费用查询  
    医生在已诊患者列表中选择某一位患者，点击“费用明细”，系统将自动刷新该患者今天的费用明细，并以表格的形式展示在界面上，费用明细包括：项目、数量、单价、开立时间、状态（已缴费、未缴费）等，还将展示该患者的已缴费总额和待支付总额。  
(4)	类的设计：  
    本系统在对于类的设计上，将PO和VO分离，PO类用于封装数据库的表对象，VO类用于封装每个页面中的数据集，这两个类的方法主要是get()和set()方法；Dao类用于读取数据库中的表对象，或者将页面中的数据存储到数据库中，即数据库的存取操作，每个Dao接口类对应一个Dao类；Servlet类用于控制事务；过滤器用于实现系统的字符编码和防盗链功能。  
    ①　PO类（一个类对应数据库的一个表）  
    ②　VO类（一个类对应一个前端页面）  
    ③　Dao类（一个Dao接口对应一个Dao类）  
    ④　Servlet类  
(5)	数据库设计：  
    主要是数据库中表的结构和关系的设计，以及数据库的函数设计。数据库中共储存了23张表和7个函数，详见仓库。  
### 四、成果展示   
(1)	用户登录  
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p1.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p2.png" width="400"></div> 
实现细节：  
①　输入账号或密码错误，会给予相应的错误提示。  
②　输入正确的账号和密码，成功登录系统首页。   
        
(2)	挂号   
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p3.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p4.png" width="800"></div> 
实现细节：  
①　初始化性别，号别，科室，医生信息，显示在下拉列表中。  
②　若之前挂过号，输入病历号，显示对应患者的个人基本信息。  
③　切换科室和号别，更新医生列表。  
④　根据号别切换诊费，普通号别和专家号别的费用从数据库中读取。  
⑤　点击挂号，进行JS表单验证，表单验证正确提交表单，否则弹出错误提示。  
⑥　挂号时需填写界面下半部分信息，挂号成功后系统将输出界面上半部分信息。  
        
(3)	医生看诊  
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p5.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p6.png" width="800"></div> 
实现细节： 
①　系统自动查找该医生当日的待诊患者和已诊患者，并以列表形式展现在左侧。   
②　在待诊患者列表中选择一位患者，点击“门诊病历”，填写该患者的病历信息。   
③　点击“保存”完成医生看诊，将数据保存到数据库，弹出成功/失败消息提示。   
        
(4)	医生开药    
界面展示：   
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p7.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p8.png" width="800"></div> 
实现细节：  
①　开药界面的诊断结果将自动读取看诊病例的诊断结果，以给医生做开药参考。  
②　填写药品信息，点击“增方”，完整的药品信息从数据库读取，用表格展示。  
③　勾选表格中的处方明细，点击“提交”完成开药，弹出成功/失败消息提示。  
        
(5)	收费    
界面展示：    
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p9.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p10.png" width="800"></div> 
实现细节：  
①　输入病历号，列出该患者的个人信息，列出费用信息的列表。  
②　选择某些行，点击“收费结算”，弹出“发票信息（交费）”遮罩弹窗。  
③　填写实收金额，使用js自动计算找零金额，显示在遮罩弹窗上。  
④　点击“收费”，保存收费信息到数据库，回显发票号。  
        
(6)	药房发药   
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p11.png" width="800"></div>  
实现细节：  
①　输入病历号和开立时间，点击“搜索”，表格中列出符合条件的所有处方明细。  
②　勾选对应的药品明细信息，点击“发药”，操作的结果将弹出提示框给予提示。  
        
(7)	退号  
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p12.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p13.png" width="800"></div> 
实现细节：  
③　输入病历号，点击“搜索”，表格中列出当日当前病历号下的所有挂号信息。   
④　选择某一行的挂号信息，点击退号，对退号操作进行校验，已经看诊的或已经退号的，弹出不允许退号提示框；退号成功，弹出提示框。  
        
(8)	费用查询  
界面展示：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p14.png" width="800"></div> 
实现细节：  
①　点击左侧患者列表的某一位患者，再点击“费用查询”，自动显示出该患者当日的费用明细，且有“未缴费”和“已缴费”的标识。  
②　系统自动计算出该患者列表费用的“已支付费用总额”和“待支付费用总额”。  
        
(9)	不同身份登录后，根据权限的不同能够使用不同的功能（隐藏无关界面），以下为财务和管理员登录后的不同功能列表：  
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p15.png" width="200"></div>   
<div align=center><img src="https://github.com/Geogy-fjq/HospitalTreatmentSystem/blob/master/READMEPhoto/p16.jpg" width="200"></div>   

### 五、开发总结  
    系统优势：采用Ajax技术实现界面的局部刷新和异步提交，相对于表单全部提交，在极大程度上提升了系统对用户的友好性；在界面的设计上，坚持美观实用的原则，最大化方便用户的使用；采用Jquery框架加快开发速度，使用SSM框架来提高系统的健壮性和兼容性；使用了过滤器完成系统的字符编码和防盗链功能，根据用户权限的不同，相应地隐藏无权限的功能界面，提升系统的安全性能。  
    系统创新：使用zTree树插件来绘制医生看诊界面的患者列表，相比于forEach极大地缩减了代码量，简化了循环输出到界面的过程；在使用Ajax技术实现局部刷新和异步提交的过程中，将JSON数据格式和JO数据格式结合使用，返回数据到JSP界面，这样可以附加数据名称用以标识返回数据，使返回数据更加清晰准确；将window.location.search和正则表达式结合使用，用于获取登录界面的账号名，并显示在功能界面的右上角。  


