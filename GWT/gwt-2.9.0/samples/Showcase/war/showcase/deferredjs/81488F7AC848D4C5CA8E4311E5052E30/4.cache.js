$wnd.showcase.runAsyncCallback4("function yp(b,a){b.multiple=a}\nfunction tbb(a,b,c){this.a=a;this.c=b;this.b=c}\nfunction QHb(a){EHb();PHb.call(this);yp((lwb(),this.hb),a)}\nfunction MHb(a,b){var c,d;fQb((lwb(),a.hb),'',b);d=a.hb.options.length;for(c=0;c<d;c++){fQb(a.hb.options[c],b,'item'+c)}}\nfunction f_(a){var b,c;b=jC(u$b(a.a,kcc),5);if(b==null){c=wB(qB(DV,1),F9b,2,6,['Cars','Sports','Vacation Spots']);x$b(a.a,kcc,c);return c}else{return b}}\nfunction e_(a){var b,c;b=jC(u$b(a.a,jcc),5);if(b==null){c=wB(qB(DV,1),F9b,2,6,['compact','sedan','coupe','convertible','SUV','truck']);x$b(a.a,jcc,c);return c}else{return b}}\nfunction h_(a){var b,c;b=jC(u$b(a.a,mcc),5);if(b==null){c=wB(qB(DV,1),F9b,2,6,['Carribean','Grand Canyon','Paris','Italy','New York','Las Vegas']);x$b(a.a,mcc,c);return c}else{return b}}\nfunction g_(a){var b,c;b=jC(u$b(a.a,lcc),5);if(b==null){c=wB(qB(DV,1),F9b,2,6,['Baseball',hcc,'Football','Hockey','Lacrosse','Polo','Soccer','Softball',icc]);x$b(a.a,lcc,c);return c}else{return b}}\nfunction qbb(a,b,c){var d,e;(lwb(),b.hb).options.length=0;e=null;switch(c){case 0:e=e_(a.a);break;case 1:e=g_(a.a);break;case 2:e=h_(a.a);}for(d=0;d<e.length;d++){FHb(b,e[d])}}\nfunction pbb(a){var b,c,d,e,f,g,h;d=new TGb;d.e[Abc]=20;b=new QHb(false);f=f_(a.a);for(e=0;e<f.length;e++){FHb(b,f[e])}MHb(b,'cwListBox-dropBox');c=new wQb;c.e[Abc]=4;tQb(c,new hDb('<b>Select a category:<\\/b>'));tQb(c,b);QGb(d,c);g=new QHb(true);MHb(g,ncc);(lwb(),g.hb).style[U7b]='11em';g.hb.size=10;h=new wQb;h.e[Abc]=4;tQb(h,new hDb('<b>Select all that apply:<\\/b>'));tQb(h,g);QGb(d,h);Lh(b,new tbb(a,g,b),(Ht(),Ht(),Gt));qbb(a,g,0);MHb(g,ncc);return d}\nvar jcc='cwListBoxCars',kcc='cwListBoxCategories',lcc='cwListBoxSports',mcc='cwListBoxVacations',ncc='cwListBox-multiBox';RX(406,1,Y9b,tbb);_.Vc=function ubb(a){qbb(this.a,this.c,fh(this.b).selectedIndex);MHb(this.c,ncc)};var sM=YWb(jac,'CwListBox/1',406);RX(407,1,eac);_.Ec=function xbb(){f$(this.b,pbb(this.a))};RX(75,247,Y7b,QHb);h7b(Fl)(4);\n//# sourceURL=showcase-4.js\n")
