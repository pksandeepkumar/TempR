/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.data.groups.GroupType;
import com.sbl.elegislature.data.reporterusers.GroupMembers;
import com.sbl.elegislature.data.reporterusers.Reporters;
import com.sbl.elegislature.models.pojo.group_member.GroupMemberPOJO;
import com.sbl.elegislature.models.pojo.group_member.ReporterGroup;
import com.sbl.elegislature.models.pojo.group_member.ReporterGroupType;
import com.sbl.elegislature.models.pojo.group_member.ReprterMember;
import com.sbl.elegislature.models.pojo.grouptype.GroupTypeData;
import com.sbl.elegislature.models.pojo.grouptype.GroupTypePOJO;
//import com.sbl.elegislature.data.reporterusers.Reporters;
import com.sbl.elegislature.models.pojo.reporterusers.GetAllUsersPOJO;
import com.sbl.elegislature.models.pojo.reporterusers.ReporterUsersData;
import com.sbl.elegislature.models.pojo.save_group.SaveGroupResponsePOJO;
import com.sbl.elegislature.models.request_params.ReporterParamAddGroup;
import com.sbl.elegislature.models.request_params.ReporterParamGroup;
import com.sbl.elegislature.models.request_params.ReporterParamGroupType;
import com.sbl.elegislature.models.request_params.ReporterParamMembers;
import com.sbl.elegislature.util.AppContext;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import com.sbl.elegislature.util.ReporterUtility;
import com.sbl.elegislature.views.baseviews.BaseWindow;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ContextMenuBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author bipin
 */
public class GroupManagementWindow extends BaseWindow {
    
    public static final String BTN_TITLE_SAVE = "Save";
    public static final String BTN_TITLE_UPDATE = "Update";

    TableView tableView;
    TreeItem selectTreeItem;
    TreeItem selectTreeGroup;
    TreeItem selectTreeGroupType;

    
    Label labelMessage;

    GroupMembers selectedEmployee;

    Set set = new HashSet();
    
    Button btnSave;

    boolean added;

    int groupIDInc;

    TreeView<Object> treeView;

    TreeItem<Object> rootTreeNode;

    Map<String, Integer> mapGroupSerialNumber;

    public GroupManagementWindow() {
        hideWindow();
        StackPane userListViewPane = new StackPane();
        StackPane groupTreeViewPane = new StackPane();

        userListViewPane.getChildren().add(showEmployeeList());

        labelMessage = getMessageLabel();
        setBottom(labelMessage);

        rootTreeNode = new TreeItem<>("Groups");
        rootTreeNode.setExpanded(true);

        initTreeView();

        groupTreeViewPane.getChildren().setAll(treeView);
        groupTreeViewPane.setMaxWidth(600);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.add(userListViewPane, 1, 0);
        grid.add(groupTreeViewPane, 2, 0);
        GridPane buttonGrid = new GridPane();

        Button btnReset = getResetButton();

        Button btnSave = getSaveButton();

        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(0, 10, 0, 10));
        buttonGrid.add(btnReset, 1, 1);
        buttonGrid.add(btnSave, 2, 1);

        grid.add(buttonGrid, 2, 1);
        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        StackPane mainCointainer = new StackPane();
        mainCointainer.getChildren().addAll(grid);//userListViewPane,groupTreeViewPane);

        setCenter(mainCointainer);

    }
    
    
     @Override
    public void refreshWindow() {
        reloadFromSever();
    }
    

    private void initTreeView() {
        initTreeData();
        treeView = new TreeView<>(rootTreeNode);
        treeView.setShowRoot(false);
        treeView.setEditable(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.err.println("getSelectionModel().selectedItemProperty()");
            if (newValue.getValue() instanceof GroupMembers) {
                selectTreeItem = (TreeItem) newValue;
                selectTreeGroup = null;
            } else if (newValue.getValue() instanceof Group) {
                selectTreeItem = null;
                selectTreeGroup = (TreeItem) newValue;

            } else {
                selectTreeItem = null;
                selectTreeGroup = null;
                selectTreeGroupType = (TreeItem) newValue;
            }
        });
        treeView.setContextMenu(getMenu());
    }

    private Button getSaveButton() {
        btnSave = new Button(BTN_TITLE_SAVE);
        btnSave.setOnAction(e -> {
            System.out.println("Save");
            saveOrUpdateGroup();
        });
        return btnSave;
    }
    
    private void setButtonSaveText(String text) {
        if(btnSave != null) {
            btnSave.setText(text);
        }
    }

    private Button getResetButton() {
        Button btnReset = new Button("Reset");
        btnReset.setOnAction(e -> {
            System.out.println("Reset");
            initTreeData();
            treeView.setRoot(null);
            treeView.setRoot(rootTreeNode);
        });
        return btnReset;
    }

    private Label getMessageLabel() {
        Label label = new Label();
        label.setTextFill(Color.web("#FE2E2E"));
        label.setText("Welcome to group Creation!!");
        return label;
    }

    private void setMessage(String message) {
        labelMessage.setText(message);
    }

    private ContextMenu getMenu() {
        ContextMenu rootContextMenu
                = ContextMenuBuilder.create().items(
                        MenuItemBuilder.create().text("Add Employee")
                                .onAction(
                                        new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent arg0) {
                                        menuAddEmployee();
                                    }
                                }
                                ).build(),
                        MenuItemBuilder.create().text("Remove Employee")
                                .onAction(
                                        new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent arg0) {
                                        menuRemoveEmployee();
                                    }
                                }
                                )
                                .build(),
                        MenuItemBuilder.create().text("Add Group")
                                .onAction(
                                        new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent arg0) {
                                        menuAddGroup();
                                    }
                                }
                                )
                                .build(),
                        MenuItemBuilder.create().text("Remove Group")
                                .onAction(
                                        new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent arg0) {
                                        menuRemoveGroup();
                                    }
                                }).build()).build();
        return rootContextMenu;
    }

    private boolean checkSessionDateSelected() {
        if (AppContext.selectedSessionDateId != 0) {
            setMessage("");
            return true;
        }
        setMessage("Please choose a session date");
        return false;
    }

    private void menuAddEmployee() {

        if (!checkSessionDateSelected()) {
            return;
        }

        System.out.println("Menu Add Employee  Clicked!");
        //System.out.println(selectItem.getValue() instanceof Employee);
        try {
            if (selectTreeItem != null) {
                if (selectTreeItem.getValue() instanceof GroupMembers) {
                    //No need to add
                }
            } else if (selectTreeGroup != null) {
                if (selectTreeGroup.getValue() instanceof Group) {

                    if (selectedEmployee != null) {
                        if (checkEmployeeAdded(selectTreeGroup.getChildren(), selectedEmployee)) {
                            setMessage("Employee Already added in this group!!!");
                            System.err.println("Employee Already added!!!");
                            return;
                        }
                        Group temp = (Group) selectTreeGroup.getValue();
                        selectedEmployee.setCreatedOn(new Date());
                        selectedEmployee.setGroupTypeId(temp.getGroupTypeIds());
                        selectedEmployee.setGroupId(temp.getId());
                        selectedEmployee.setLevel(1);
                        selectedEmployee.setSupervisorId(AppContext.application().employeeId);//hard coded
                        selectedEmployee.setGroupLeaderId(selectedEmployee.getEmployeeId());
                        if (temp.getGroupLeaderIds() != null && temp.getGroupLeaderIds() == 0) {
                            temp.setGroupLeaderIds(selectedEmployee.getId());

                        }
//                        employees.add(selectedEmployee);
                        TreeItem<Object> employeeItem = new TreeItem<>(selectedEmployee);
                        selectTreeGroup.getChildren().add(employeeItem);
                    }
                }
            } else {
                //Group type node
            }
        } catch (Exception e) {
            System.out.println("NODE IS NOT VALID");
        }
    }

    private void saveOrUpdateGroup() {

        ReporterParamAddGroup addGroup = new ReporterParamAddGroup();
        if (treeView.getRoot() != null && treeView.getRoot().getChildren() != null) {
            List<ReporterParamGroupType> groupTypeParamList = new ArrayList<ReporterParamGroupType>();
            addGroup.setReporterGroupTypes(groupTypeParamList);

            for (TreeItem<Object> treeObjectGroupType : treeView.getRoot().getChildren()) {
                GroupType groupType = (GroupType) treeObjectGroupType.getValue();
                ReporterParamGroupType reporterParamGroupType = new ReporterParamGroupType(groupType);
                groupTypeParamList.add(reporterParamGroupType);

                System.err.println("GroupType:" + groupType);

                if (treeObjectGroupType.getChildren() != null) {
                    for (TreeItem<Object> treeObjectGroup : treeObjectGroupType.getChildren()) {
                        Group group = (Group) treeObjectGroup.getValue();
                        ReporterParamGroup reporterParamGroup = new ReporterParamGroup(group);
                        reporterParamGroupType.getReporterGroup().add(reporterParamGroup);

                        System.err.println("Group:" + group);
                        if (treeObjectGroup.getChildren() != null) {
                            for (TreeItem<Object> treeMember : treeObjectGroup.getChildren()) {
                                GroupMembers groupMember = (GroupMembers) treeMember.getValue();
                                ReporterParamMembers reporterParamMembers = new ReporterParamMembers(groupMember);
                                reporterParamGroup.getReprterMembers().add(reporterParamMembers);

                                System.err.println("GroupMembers:" + groupMember);
                            }
                        }
                    }
                }
            }
        }

        System.err.println(":" + addGroup);
        ObjectMapper mapper = new ObjectMapper();
        try {
            // get Employee object as a json string
            String jsonStr = mapper.writeValueAsString(addGroup);
            SaveGroupResponsePOJO pojo = generalServiceInstance().saveGroupMember(jsonStr);
            if(pojo != null) {
                if( pojo.getData() != null) {
                    if(pojo.getData().getStatus()) {
                        setMessage("Saved succesfully");
                        reloadFromSever();
                    } else {
                        setMessage("Something went wrong. Please try later");
                    }
                }
            } else {
                setMessage("Something went wrong. Please try later"); 
            }
            System.out.println(jsonStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean checkEmployeeAdded(ObservableList<TreeItem<Object>> itemTree, GroupMembers employee) {
        if (itemTree != null && employee != null) {
            for (TreeItem<Object> treeObject : itemTree) {
                GroupMembers tempGroupMember = (GroupMembers) treeObject.getValue();
                if (tempGroupMember != null && employee.getEmployeeId()== tempGroupMember.getEmployeeId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void menuRemoveEmployee() {
        if (!checkSessionDateSelected()) {
            return;
        }
        System.out.println("delete Menu Item selected!");
        GroupMembers temp = (GroupMembers) selectTreeItem.getValue();
        set.remove(temp.getId());
        boolean status = selectTreeItem.getParent().getChildren().remove(selectTreeItem);
    }

    private void menuAddGroup() {
        if (!checkSessionDateSelected()) {
            return;
        }
        System.out.println("   selected   grouptype   is  " + selectTreeGroupType.getValue());
//        String groupNameNew = "Group" + Integer.toString(groupIDInc);
        int serialNumber = getLatestSerialNumber(selectTreeGroupType.getValue().toString());
        String groupNameNew = selectTreeGroupType.getValue().toString() + ++serialNumber;
        putLatestSerialNumber(selectTreeGroupType.getValue().toString(), serialNumber);

        GroupType tempGroupType = (GroupType) selectTreeGroupType.getValue();
        Group newGroup = new Group(0, groupNameNew, tempGroupType.getId());//id, name, grouptypeid)
        TreeItem<Object> newGroupTreeItem = new TreeItem<>(newGroup);
        selectTreeGroupType.getChildren().add(newGroupTreeItem);
        groupIDInc++;
    }

    private void menuRemoveGroup() {
        if (!checkSessionDateSelected()) {
            return;
        }
        if (selectTreeItem != null) {
            if (selectTreeItem.getValue() instanceof GroupMembers) {
                GroupMembers temp = (GroupMembers) selectTreeItem.getValue();

                //  String groupName=temp.getGroupeTypeName();
                for (TreeItem<Object> groupNode : rootTreeNode.getChildren()) {
                    GroupType tempGroupType = (GroupType) groupNode.getValue();
                    if (tempGroupType.getName().equals(temp.getGroupTypeName())) {
                        System.out.println(groupNode.getValue());
                        for (TreeItem<Object> depNode : groupNode.getChildren()) {
                            Group tempGroup = (Group) depNode.getValue();
                            if (new Integer(tempGroup.getId()).equals(temp.getGroupId())) {
                                selectTreeItem = new TreeItem();
                            }
                            System.out.println(depNode.getValue());
                            {
                                groupNode.getChildren().remove(depNode);
                                System.out.println("Deleted...");
                                break;
                            }
                        }
                    }

                }
            }
        } else if (selectTreeGroup != null) {
            if (selectTreeGroup.getValue() instanceof Group) {
                System.out.println(selectTreeGroup.getValue() + "..........selected");
                Group temp = (Group) selectTreeGroup.getValue();
                selectTreeGroup.getParent().getChildren().remove(selectTreeGroup);
            }
        }
    }

    public List<ReporterUsersData> loadGetAllUsers() {
        GetAllUsersPOJO getAllUsersPOJO = generalServiceInstance().getAllUsers();
        if (getAllUsersPOJO != null) {
            List<ReporterUsersData> reporterUsers = getAllUsersPOJO.getData();
            return reporterUsers;
        }
        return null;
    }

    TableView showEmployeeList() {
        tableView = new TableView();
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn role = new TableColumn("Role");
        role.setCellValueFactory(new PropertyValueFactory("designation"));
        tableView.getColumns().setAll(name, role);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List userList = new ArrayList();//generalServiceInstance().getEmployeeList(6); //   department id of reporters

        List<ReporterUsersData> reporterUsers = loadGetAllUsers();
        if (reporterUsers != null) {
            reporterUsers.stream().forEach((data) -> userList.add(data));
        }
        tableView.getItems().setAll(userList);

        tableView.setRowFactory(rowClick -> {
            TableRow<ReporterUsersData> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ReporterUsersData rowData = row.getItem();
                    setSelectedEmployee(rowData);
                }
            }
            );
            return row;
        });
        return tableView;

    }

    private void setSelectedEmployee(ReporterUsersData reporter) {
        selectedEmployee = new GroupMembers();
        selectedEmployee.setCreated_By(AppContext.application().employeeId);//hard coded
        selectedEmployee.setSessionDateId(AppContext.selectedSessionDateId);//hardcoded
        selectedEmployee.setEmployeeId(reporter.getEmployeeId());
        selectedEmployee.setFirstName(reporter.getName());
        selectedEmployee.setNames(reporter.getName());
        System.err.println("selectedEmployee:"+ selectedEmployee.getEmployeeId());
    }

    private void putLatestSerialNumber(String groupName, int slNumber) {
        mapGroupSerialNumber.put(groupName, slNumber);
    }

    private int getLatestSerialNumber(String groupName) {
        Integer serialNumber = mapGroupSerialNumber.get(groupName);
        if (serialNumber != null) {
            return serialNumber;
        }
        return 0;
    }

    private void setGroupTypeToTree(ObservableList<GroupType> groupTypes) {
        for (GroupType group : groupTypes) {
            TreeItem<Object> grouptype = new TreeItem<>(group);
            rootTreeNode.getChildren().add(grouptype);
        }
    }

    private void initTreeData() {
        mapGroupSerialNumber = new HashMap<String, Integer>();
        List<GroupMembers> employees = FXCollections.observableArrayList();
        ObservableList<GroupType> groupTypes = FXCollections.observableArrayList();
        ObservableList<Group> groups = FXCollections.observableArrayList();
        fetchgroupTypeList(groupTypes);
        rootTreeNode.getChildren().clear();
        setGroupTypeToTree(groupTypes);
        setButtonSaveText(BTN_TITLE_SAVE);
    }

    private void reloadFromSever() {
        if (!checkSessionDateSelected()) {
            return;
        }
        List<GroupMembers> employees = FXCollections.observableArrayList();
        ObservableList<GroupType> groupTypes = FXCollections.observableArrayList();
        ObservableList<Group> groups = FXCollections.observableArrayList();

        System.err.println("rootTreeNode.getChildren().length:" + rootTreeNode.getChildren());
        rootTreeNode.getChildren().clear();
        rootTreeNode = new TreeItem<>("Groups");
        treeView.setRoot(null);
        treeView.setRoot(rootTreeNode);
        System.err.println("rootTreeNode.getChildren().length:" + rootTreeNode.getChildren());

//        csrf
        GroupMemberPOJO groupMemberPOJO = generalServiceInstance()
                .getGroupMemberPOJO(AppContext.selectedSessionDateId);
        if (groupMemberPOJO != null) {
//            initTreeData();
            if (groupMemberPOJO.getData() != null) {
                List groupTypeList = new ArrayList();
                if (groupMemberPOJO.getData().getReporterGroupTypes() != null) {
                    
                    if(groupMemberPOJO.getData().getReporterGroupTypes().size() == 0) {
                        initTreeData(); return;
                    }
                    
                    setButtonSaveText(BTN_TITLE_UPDATE);
                    for (ReporterGroupType reporterGroupType : groupMemberPOJO.getData().getReporterGroupTypes()) {
                        TreeItem<Object> grouptypeNodeItem = new TreeItem<>(new GroupType(reporterGroupType.getId(), reporterGroupType.getName()));
                        rootTreeNode.getChildren().add(grouptypeNodeItem);

                        if (reporterGroupType.getReporterGroup() != null) {
                            List grouplist = new ArrayList();
                            for (ReporterGroup reporterGroup : reporterGroupType.getReporterGroup()) {

                                TreeItem groupNodeItem = new TreeItem(new Group(reporterGroup.getId(),
                                        ReporterUtility.getFirstWord(reporterGroup.getName()), reporterGroupType.getId()));
                                grouptypeNodeItem.getChildren().add(groupNodeItem);

                                if (reporterGroup.getReprterMembers() != null) {
                                    List employeeList = new ArrayList();
                                    for (ReprterMember reprterMember : reporterGroup.getReprterMembers()) {
                                        TreeItem employeeNodeItem = new TreeItem(new GroupMembers(reprterMember.getId(),
                                                reprterMember.getName(), reprterMember.getLevel(), reporterGroup.getId(),
                                                reporterGroupType.getName(), reprterMember.getEmployeeId()));
                                        groupNodeItem.getChildren().add(employeeNodeItem);
                                    }
                                    employees.addAll(employeeList);
                                }
                            }
                            groups.addAll(grouplist);
                        }
                    }
                    groupTypes.addAll(groupTypeList);

                } else {
                    initTreeData();
                }
            } else {
                initTreeData();
            }
        } else {
            initTreeData();
        }

    }

    private void fetchgroupTypeList(ObservableList groupTypes) {
        List groupTypeList = new ArrayList();//generalServiceInstance().getGroupType();
        GroupTypePOJO groupTypePOJO = generalServiceInstance().getGroupTypePojo();
        if (groupTypePOJO != null) {
            List<GroupTypeData> groupTypeDataList = groupTypePOJO.getData();
            if (groupTypeDataList != null) {
                groupTypeDataList.forEach((data) -> {
                    groupTypeList.add(new GroupType(data.getId(), data.getName()));
                });
            }
        }
        groupTypes.addAll(groupTypeList);
    }

    private void setEmployeetoTree(TreeItem<Object> depNode, TreeItem<Object> empLeaf) {
        for (TreeItem<Object> node : depNode.getChildren()) {

            GroupMembers tempNode = (GroupMembers) node.getValue();
            GroupMembers newNode = (GroupMembers) empLeaf.getValue();
            if (tempNode.getEmployeeId() == newNode.getSupervisorId()) {
                node.getChildren().add(empLeaf);
                added = true;
                return;
            } else {
                setEmployeetoTree(node, empLeaf);
            }
        }
    }

}
