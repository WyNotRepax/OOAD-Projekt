$wnd.showcase.runAsyncCallback1("function E_(a){var b,c;b=sC(M$b(a.a,vcc),5);if(b==null){c=FB(zB(OV,1),Y9b,2,6,[wcc,xcc,ycc,zcc]);P$b(a.a,vcc,c);return c}else{return b}}\nfunction F_(a){var b,c;b=sC(M$b(a.a,Acc),5);if(b==null){c=FB(zB(OV,1),Y9b,2,6,['Baseball',Bcc,'Football','Hockey','Soccer',Ccc]);P$b(a.a,Acc,c);return c}else{return b}}\nfunction eib(a){var b,c,d,e,f,g,h,i;i=new IQb;FQb(i,new sDb('<b>Select your favorite color:<\\/b>'));c=E_(a.a);for(e=0;e<c.length;e++){b=c[e];f=new FLb(jac,b);Rzb(f,'cwRadioButton-color-'+b);e==2&&(f.c.disabled=true,undefined,ph(f,wh(f.hb)+'-'+Kac,true));FQb(i,f)}FQb(i,new sDb('<br><b>Select your favorite sport:<\\/b>'));h=F_(a.a);for(d=0;d<h.length;d++){g=h[d];f=new FLb('sport',g);Rzb(f,'cwRadioButton-sport-'+mYb(g,' ',''));d==2&&Szb(f,(UWb(),true));FQb(i,f)}return i}\nvar vcc='cwRadioButtonColors',Acc='cwRadioButtonSports';aY(399,1,xac);_.Ec=function jib(){u$(this.b,eib(this.a))};z7b(Cl)(1);\n//# sourceURL=showcase-1.js\n")