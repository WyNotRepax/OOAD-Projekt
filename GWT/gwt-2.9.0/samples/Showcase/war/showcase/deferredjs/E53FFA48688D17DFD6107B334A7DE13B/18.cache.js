$wnd.showcase.runAsyncCallback18("function dB(){}\nfunction QKb(a,b){Sx(a.a,b)}\nfunction jhb(a,b){this.b=a;this.a=b}\nfunction lhb(a,b){this.b=a;this.a=b}\nfunction DB(a){return IZ(oB,a)}\nfunction cB(){cB=UY;bB=new dB}\nfunction dhb(a,b){_Db(b,'\\u5DF2\\u9009\\u62E9: '+a.Zf()+', '+a.$f())}\nfunction aLb(){YKb();_Kb.call(this,So($doc,'password'),'gwt-PasswordTextBox')}\nfunction GSb(b){try{var c=b.document.selection.createRange();if(c.parentElement()!==b)return 0;return c.text.length}catch(a){return 0}}\nfunction FSb(b){try{var c=b.document.selection.createRange();if(c.parentElement()!==b)return -1;return -c.move(Gec,-65535)}catch(a){return 0}}\nfunction bhb(a,b){var c,d;c=new UHb;c.e[Lcc]=4;RHb(c,a);if(b){d=new dEb('\\u5DF2\\u9009\\u62E9: 0, 0');Ih(a,new jhb(a,d),(Au(),Au(),zu));Ih(a,new lhb(a,d),(Zt(),Zt(),Yt));RHb(c,d)}return c}\nfunction ISb(b){try{var c=b.document.selection.createRange();if(c.parentElement()!==b)return 0;var d=c.text.length;var e=0;var f=c.duplicate();f.moveEnd(Gec,-1);var g=f.text.length;while(g==d&&f.parentElement()==b&&c.compareEndPoints('StartToEnd',f)<=0){e+=2;f.moveEnd(Gec,-1);g=f.text.length}return d+e}catch(a){return 0}}\nfunction HSb(b){try{var c=b.document.selection.createRange();if(c.parentElement()!==b)return -1;var d=c.duplicate();d.moveToElementText(b);d.setEndPoint('EndToStart',c);var e=d.text.length;var f=0;var g=d.duplicate();g.moveEnd(Gec,-1);var h=g.text.length;while(h==e&&g.parentElement()==b){f+=2;g.moveEnd(Gec,-1);h=g.text.length}return e+f}catch(a){return 0}}\nfunction chb(){var a,b,c,d,e,f;f=new yRb;f.e[Lcc]=5;d=new $Kb;hRb(d.hb,'','cwBasicText-textbox');QKb(d,(cB(),cB(),bB));b=new $Kb;hRb(b.hb,'','cwBasicText-textbox-disabled');b.hb[Edc]=Eec;Rx(b.a);b.hb[Cbc]=true;vRb(f,new iEb('<b>\\u5E38\\u89C4\\u6587\\u672C\\u6846:<\\/b>'));vRb(f,bhb(d,true));vRb(f,bhb(b,false));c=new aLb;hRb(c.hb,'','cwBasicText-password');a=new aLb;hRb(a.hb,'','cwBasicText-password-disabled');a.hb[Edc]=Eec;Rx(a.a);a.hb[Cbc]=true;vRb(f,new iEb('<br><br><b>\\u5BC6\\u7801\\u6587\\u672C\\u6846:<\\/b>'));vRb(f,bhb(c,true));vRb(f,bhb(a,false));e=new CPb;hRb(e.hb,'','cwBasicText-textarea');e.hb.rows=5;vRb(f,new iEb('<br><br><b>\\u6587\\u672C\\u533A\\u57DF:<\\/b>'));vRb(f,bhb(e,true));return f}\nvar Eec='\\u53EA\\u8BFB',Gec='character';TY(876,1153,{},dB);_.ud=function eB(a){return DB((xB(),a))?(_z(),$z):(_z(),Zz)};var bB;var kJ=eYb(aac,'AnyRtlDirectionEstimator',876);TY(445,1,obc);_.Ec=function ihb(){l_(this.a,chb())};TY(446,1,Fec,jhb);_.Yc=function khb(a){dhb(this.b,this.a)};var HO=eYb(zbc,'CwBasicText/2',446);TY(447,1,ebc,lhb);_.Wc=function mhb(a){dhb(this.b,this.a)};var IO=eYb(zbc,'CwBasicText/3',447);TY(754,247,f9b);_.Zf=function TKb(){return FSb(this.hb)};_.$f=function UKb(){return GSb(this.hb)};TY(327,50,f9b,aLb);var AT=eYb(d9b,'PasswordTextBox',327);TY(216,313,f9b);_.Zf=function DPb(){return HSb(this.hb)};_.$f=function EPb(){return ISb(this.hb)};p8b(Cl)(18);\n//# sourceURL=showcase-18.js\n")
