# UIComponent
---
## ListView---`SimpleAdapter`
[SimpleAdapter.java](https://github.com/Propantheline/UIComponent/blob/master/app/src/main/java/com/example/experiment2/SimpleAdapterTest.java)
```
private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "elephant"};
    private int[] image = new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //此处引用布局文件
        setContentView(R.layout.activity_simple_adapter);
        final int color1 = 0xFFC5B5FF;
        final int color2 = 0xFFFFFFFF;
        //创建一个list集合，list集合的元素是Map
        List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", names[i]);
            listItem.put("images", image[i]);
            //加入list集合
            ListItems.add(listItem);
        }
        //创建一个SimpleAdapter，此处严格按照定义数组names与image顺序,否则会出现程序build成功却运行失败且难以解决错误
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.items, new String[]{"header", "images"}, new int[]{R.id.header, R.id.images});
        final ListView list = (ListView) findViewById(R.id.listview);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
```
###  screenshot
![ SimpleAdapter ](https://img-blog.csdnimg.cn/20190327142911985.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTMxNTI5NA==,size_16,color_FFFFFF,t_70 "SimpleAdapter")

---
## AlertDialog
[AlertDialog.xml](https://github.com/Propantheline/UIComponent/blob/master/app/src/main/res/layout/activity_alert_dialog_test.xml)
```
 public void login(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(R.layout.activity_alert_dialog_test)
                .show();
        Button sign = dialog.findViewById(R.id.sign);
        Button cancel = dialog.findViewById(R.id.cancel);
        if (cancel != null) {
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
        if (sign != null) {
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = dialog.findViewById(R.id.username);
                    if (editText != null) {
                        Toast.makeText(getApplicationContext(), "Sign in success", Toast.LENGTH_LONG).show();
                }
            }
         });
        }
    }
```
### screenshot
![AlertDialog](https://img-blog.csdnimg.cn/20190327144100955.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTMxNTI5NA==,size_16,color_FFFFFF,t_70 " AlertDialog")

---
## XMLMenu
[XMLMenu.java](https://github.com/Propantheline/UIComponent/blob/master/app/src/main/java/com/example/experiment2/XMLmenu.java)
```
//菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            //勾选菜单项
            item.setCheckable(true);
        }
        //switch 判断单击哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()) {
            case R.id.small:
                textView.setTextSize(10 * 2);
                break;

            case R.id.medium:
                textView.setTextSize(16 * 2);
                break;
            case R.id.large:
                textView.setTextSize(20 * 2);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                textView.setTextColor(Color.BLACK);
                break;
            case R.id.simple:
                Toast.makeText(XMLmenu.this,"这是普通选择项",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
```
### screenshot
![XMLMenu](https://img-blog.csdnimg.cn/20190327144355676.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTMxNTI5NA==,size_16,color_FFFFFF,t_70 " XMLMenu")

---
## ListView---` ActionMode`    
[ActionModeTest.java](https://github.com/Propantheline/UIComponent/blob/master/app/src/main/java/com/example/experiment2/ActionModeTest.java)
```
 mAdapter = new SelectionAdapter(this,
                R.layout.items2, R.id.num, data);
        list.setAdapter(mAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private int nr = 0;

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                mAdapter.clearSelection();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub

                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {

                    case R.id.delete_item:
                        nr = 0;
                        mAdapter.clearSelection();
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
                if (checked) {
                    nr++;
                    mAdapter.setNewSelection(position, checked);
                } else {
                    nr--;
                    mAdapter.removeSelection(position);
                }
                mode.setTitle(nr + " selected");

            }
        });
```
       
