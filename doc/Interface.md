# Interface Documentation

|                 url                 |                                                          parameter                                                          |    return    |
|:-----------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|:------------:|
|             /verifyCode             |                                                              -                                                              |     jpeg     |
|             /user/login             |                                             String: name, password, verifyCode                                              | ModelAndView |
|         /gather/gatherList          |         Pager: pager; String: isDel, exportType; Integer[] selectedId; Gather: bean; HttpServletResponse: response;         | ModelAndView |
|     /gather/toAddOrUpdateGather     |                                                      Integer: edit_id;                                                      | ModelAndView |
|      /gather/addOrUpdateGather      |                Gather: gather; Integer: edit_id;                                           Integer: edit_id;                | ModelAndView |
|     /needGather/needGatherList      |       Pager: pager; String: isDel, exportType; Integer[] selectedId; NeedGather: bean; HttpServletResponse: response;       | ModelAndView |
|      /needGather/toAddOrUpdate      |                                                      Integer: edit_id;                                                      | ModelAndView |
|       /needGather/addOrUpdate       |                 Order: bean; Integer: edit_id;                                           Integer: edit_id;                  | ModelAndView |
|          /order/orderList           |       Pager: pager; String: isDel, exportType; Integer[] selectedId; NeedGather: bean; HttpServletResponse: response;       | ModelAndView |
|      /order/toAddOrUpdateOrder      |                                                      Integer: edit_id;                                                      | ModelAndView |
|       /order/addOrUpdateOrder       |                 Order: bean; Integer: edit_id;                                           Integer: edit_id;                  | ModelAndView |
|        /product/productList         |       Pager: pager; String: isDel, exportType; Integer[] product_id; Product: product; HttpServletResponse: response;       | ModelAndView |
|        /product/toAddProduct        |                                                      Integer: edit_id;                                                      | ModelAndView |
|     /product/addOrUpdateProduct     |               Product: product; Integer: edit_id;                                           Integer: edit_id;               | ModelAndView |
|    /productType/productTypeList     | Pager: pager; String: isDel, exportType; Integer[] productType_id; ProductType: productType; HttpServletResponse: response; | ModelAndView |
|    /productType/toAddProductType    |                                                      Integer: edit_id;                                                      | ModelAndView |
| /productType/addOrUpdateProductType |           ProductType: productType; Integer: edit_id;                                           Integer: edit_id;           | ModelAndView |
|    /productType/optionTreeWindow    |                                                              -                                                              | ModelAndView |
|  /productType/getSelectOptionsStr   |                                                              -                                                              |    String    |
|           /role/roleList            |                         Pager: pager; String: isDel, exportType; Integer[] selectedId; Role: role;                          | ModelAndView |
|         /role/load4AddRole          |                                                              -                                                              | ModelAndView |
|            /role/roleAdd            |                          Role: role;                                            Integer: edit_id;                           | ModelAndView |
|           /user/userList            |   Pager: pager; String: isDel, exportType changeStatus; Integer[] selectedId; User: bean; HttpServletResponse: response;    | ModelAndView |
|         /user/toAddOrUpdate         |                                                      Integer: edit_id;                                                      | ModelAndView |
|          /user/addOrUpdate          |                  User: bean; Integer: edit_id;                                           Integer: edit_id;                  | ModelAndView |
|          /group/groupList           |   Pager: pager; String: isDel, exportType changeStatus; Integer[] selectedId; User: bean; HttpServletResponse: response;    | ModelAndView |
|        /group/toAddOrUpdate         |                                                      Integer: edit_id;                                                      | ModelAndView |
|         /group/addOrUpdate          |                  User: bean; Integer: edit_id;                                           Integer: edit_id;                  | ModelAndView |
|       /group/optionTreeWindow       |                                -                                           Integer: edit_id;                                | ModelAndView |
|        /group/toSetUserGroup        |                   Integer: edit_id; String: ids                                         Integer: edit_id;                   | ModelAndView |
