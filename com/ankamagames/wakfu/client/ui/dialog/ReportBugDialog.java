package com.ankamagames.wakfu.client.ui.dialog;

import java.util.*;
import com.ankamagames.xulor2.util.*;
import com.ankamagames.xulor2.event.listener.*;
import com.ankamagames.xulor2.nongraphical.*;
import com.ankamagames.xulor2.core.*;
import com.ankamagames.xulor2.util.alignment.*;
import com.ankamagames.xulor2.*;
import com.ankamagames.xulor2.property.*;
import com.ankamagames.xulor2.core.renderer.condition.*;
import com.ankamagames.xulor2.component.*;
import com.ankamagames.xulor2.decorator.*;
import com.ankamagames.framework.graphics.image.*;
import com.ankamagames.xulor2.layout.*;
import com.ankamagames.xulor2.appearance.*;

public class ReportBugDialog implements BasicElementFactory
{
    private Stack<ElementMap> elementMaps;
    private Environment env;
    
    public ReportBugDialog() {
        super();
        this.elementMaps = new Stack<ElementMap>();
    }
    
    @Override
    public BasicElement getElement(final Environment env, final ElementMap item) {
        this.env = env;
        this.elementMaps.push(item);
        final ElementMap elementMap = this.elementMaps.peek();
        final Container checkOut = Container.checkOut();
        checkOut.setElementMap(elementMap);
        checkOut.onAttributesInitialized();
        final StaticLayoutData element = new StaticLayoutData();
        element.onCheckOut();
        element.setElementMap(elementMap);
        element.setAlign(Alignment17.NORTH_WEST);
        element.setSize(new Dimension(-2, -2));
        checkOut.addBasicElement(element);
        element.onAttributesInitialized();
        element.onChildrenAdded();
        final Button element2 = new Button();
        element2.onCheckOut();
        element2.setElementMap(elementMap);
        element2.setStyle("bug");
        final MouseClickedListener onClick = new MouseClickedListener();
        onClick.setCallBackFunc("wakfu:openReportBugDialog");
        element2.setOnClick(onClick);
        final PopupDisplayListener onPopupDisplay = new PopupDisplayListener();
        onPopupDisplay.setCallBackFunc("popup(descBugReportPopup)");
        element2.setOnPopupDisplay(onPopupDisplay);
        final PopupHideListener onPopupHide = new PopupHideListener();
        onPopupHide.setCallBackFunc("closePopup");
        element2.setOnPopupHide(onPopupHide);
        element2.setExpandable(false);
        checkOut.addBasicElement(element2);
        element2.onAttributesInitialized();
        final String id = "descBugReportPopup";
        final PopupElement popupElement = new PopupElement();
        popupElement.onCheckOut();
        popupElement.setElementMap(elementMap);
        if (elementMap != null && id != null) {
            elementMap.add(id, popupElement);
        }
        popupElement.setAlign(Alignment9.NORTH_WEST);
        popupElement.setHotSpotPosition(Alignment9.NORTH_EAST);
        element2.addBasicElement(popupElement);
        popupElement.onAttributesInitialized();
        final Container checkOut2 = Container.checkOut();
        checkOut2.setElementMap(elementMap);
        checkOut2.setPrefSize(new Dimension(10, 0));
        checkOut2.setStyle("popup");
        popupElement.addBasicElement(checkOut2);
        checkOut2.onAttributesInitialized();
        final BorderLayoutData checkOut3 = BorderLayoutData.checkOut();
        checkOut3.setElementMap(elementMap);
        checkOut3.setData(BorderLayoutData.Values.CENTER);
        checkOut2.addBasicElement(checkOut3);
        checkOut3.onAttributesInitialized();
        checkOut3.onChildrenAdded();
        final Label element3 = new Label();
        element3.onCheckOut();
        element3.setElementMap(elementMap);
        element3.setStyle("PopupInformation");
        element3.setText("%desc.bugReport%".replace("%desc.bugReport%", Xulor.getInstance().getTranslatedString("desc.bugReport")));
        checkOut2.addBasicElement(element3);
        element3.onAttributesInitialized();
        final DecoratorAppearance appearance = element3.getAppearance();
        appearance.setElementMap(elementMap);
        ((TextWidgetAppearance)appearance).setAlignment(Alignment9.WEST);
        element3.addBasicElement(appearance);
        appearance.onAttributesInitialized();
        appearance.onChildrenAdded();
        element3.onChildrenAdded();
        checkOut2.onChildrenAdded();
        popupElement.onChildrenAdded();
        final PropertyElement checkOut4 = PropertyElement.checkOut();
        checkOut4.setElementMap(elementMap);
        checkOut4.setName("reportBug");
        checkOut4.setAttribute("visible");
        element2.addBasicElement(checkOut4);
        checkOut4.onAttributesInitialized();
        final ConditionResult element4 = new ConditionResult();
        element4.onCheckOut();
        element4.setElementMap(elementMap);
        checkOut4.addBasicElement(element4);
        element4.onAttributesInitialized();
        final AndCondition element5 = new AndCondition();
        element5.onCheckOut();
        element5.setElementMap(elementMap);
        element4.addBasicElement(element5);
        element5.onAttributesInitialized();
        final TrueCondition element6 = new TrueCondition();
        element6.onCheckOut();
        element6.setElementMap(elementMap);
        element5.addBasicElement(element6);
        element6.onAttributesInitialized();
        element6.onChildrenAdded();
        final FalseCondition element7 = new FalseCondition();
        element7.onCheckOut();
        element7.setElementMap(elementMap);
        element5.addBasicElement(element7);
        element7.onAttributesInitialized();
        final PropertyElement checkOut5 = PropertyElement.checkOut();
        checkOut5.setElementMap(elementMap);
        checkOut5.setAttribute("comparedValue");
        checkOut5.setName("isInGame");
        element7.addBasicElement(checkOut5);
        checkOut5.onAttributesInitialized();
        checkOut5.onChildrenAdded();
        element7.onChildrenAdded();
        element5.onChildrenAdded();
        element4.onChildrenAdded();
        checkOut4.onChildrenAdded();
        element2.onChildrenAdded();
        final Container checkOut6 = Container.checkOut();
        checkOut6.setElementMap(elementMap);
        checkOut6.setNonBlocking(false);
        final PopupDisplayListener onPopupDisplay2 = new PopupDisplayListener();
        onPopupDisplay2.setCallBackFunc("popup(preloadingPopup)");
        checkOut6.setOnPopupDisplay(onPopupDisplay2);
        final PopupHideListener onPopupHide2 = new PopupHideListener();
        onPopupHide2.setCallBackFunc("closePopup");
        checkOut6.setOnPopupHide(onPopupHide2);
        checkOut.addBasicElement(checkOut6);
        checkOut6.onAttributesInitialized();
        final DecoratorAppearance appearance2 = checkOut6.getAppearance();
        appearance2.setElementMap(elementMap);
        appearance2.setShape(WidgetShape.CIRCLE);
        checkOut6.addBasicElement(appearance2);
        appearance2.onAttributesInitialized();
        appearance2.onChildrenAdded();
        final StaticLayout element8 = new StaticLayout();
        element8.onCheckOut();
        element8.setAdaptToContentSize(true);
        checkOut6.addBasicElement(element8);
        element8.onAttributesInitialized();
        element8.onChildrenAdded();
        final String id2 = "preloadingPopup";
        final PopupElement popupElement2 = new PopupElement();
        popupElement2.onCheckOut();
        popupElement2.setElementMap(elementMap);
        if (elementMap != null && id2 != null) {
            elementMap.add(id2, popupElement2);
        }
        popupElement2.setAlign(Alignment9.NORTH_EAST);
        popupElement2.setHotSpotPosition(Alignment9.NORTH_WEST);
        checkOut6.addBasicElement(popupElement2);
        popupElement2.onAttributesInitialized();
        final Container checkOut7 = Container.checkOut();
        checkOut7.setElementMap(elementMap);
        checkOut7.setPrefSize(new Dimension(10, 0));
        checkOut7.setStyle("popup");
        popupElement2.addBasicElement(checkOut7);
        checkOut7.onAttributesInitialized();
        final RowLayout checkOut8 = RowLayout.checkOut();
        checkOut8.setHorizontal(false);
        checkOut7.addBasicElement(checkOut8);
        checkOut8.onAttributesInitialized();
        checkOut8.onChildrenAdded();
        final TextView element9 = new TextView();
        element9.onCheckOut();
        element9.setElementMap(elementMap);
        element9.setStyle("PopupInformation");
        checkOut7.addBasicElement(element9);
        element9.onAttributesInitialized();
        final DecoratorAppearance appearance3 = element9.getAppearance();
        appearance3.setElementMap(elementMap);
        ((TextWidgetAppearance)appearance3).setAlignment(Alignment9.WEST);
        element9.addBasicElement(appearance3);
        appearance3.onAttributesInitialized();
        appearance3.onChildrenAdded();
        final PropertyElement checkOut9 = PropertyElement.checkOut();
        checkOut9.setElementMap(elementMap);
        checkOut9.setAttribute("text");
        checkOut9.setName("preloading.progressDescription");
        element9.addBasicElement(checkOut9);
        checkOut9.onAttributesInitialized();
        checkOut9.onChildrenAdded();
        element9.onChildrenAdded();
        final TextView element10 = new TextView();
        element10.onCheckOut();
        element10.setElementMap(elementMap);
        element10.setStyle("PopupInformation");
        element10.setMinWidth(1);
        element10.setMaxWidth(250);
        checkOut7.addBasicElement(element10);
        element10.onAttributesInitialized();
        final DecoratorAppearance appearance4 = element10.getAppearance();
        appearance4.setElementMap(elementMap);
        ((TextWidgetAppearance)appearance4).setAlignment(Alignment9.WEST);
        element10.addBasicElement(appearance4);
        appearance4.onAttributesInitialized();
        appearance4.onChildrenAdded();
        final PropertyElement checkOut10 = PropertyElement.checkOut();
        checkOut10.setElementMap(elementMap);
        checkOut10.setAttribute("text");
        checkOut10.setName("preloading.componentDescription");
        element10.addBasicElement(checkOut10);
        checkOut10.onAttributesInitialized();
        checkOut10.onChildrenAdded();
        element10.onChildrenAdded();
        checkOut7.onChildrenAdded();
        popupElement2.onChildrenAdded();
        final Image element11 = new Image();
        element11.onCheckOut();
        element11.setElementMap(elementMap);
        element11.setStyle("preloading");
        element11.setDisplaySize(new Dimension(48, 48));
        element11.setPrefSize(new Dimension(48, 48));
        checkOut6.addBasicElement(element11);
        element11.onAttributesInitialized();
        final StaticLayoutData element12 = new StaticLayoutData();
        element12.onCheckOut();
        element12.setElementMap(elementMap);
        element12.setSize(new Dimension(-2, -2));
        element12.setAlign(Alignment17.CENTER);
        element11.addBasicElement(element12);
        element12.onAttributesInitialized();
        element12.onChildrenAdded();
        final PropertyElement checkOut11 = PropertyElement.checkOut();
        checkOut11.setElementMap(elementMap);
        checkOut11.setName("preloading.isFailing");
        checkOut11.setAttribute("visible");
        element11.addBasicElement(checkOut11);
        checkOut11.onAttributesInitialized();
        checkOut11.onChildrenAdded();
        final DecoratorAppearance appearance5 = element11.getAppearance();
        appearance5.setElementMap(elementMap);
        element11.addBasicElement(appearance5);
        appearance5.onAttributesInitialized();
        final PropertyElement checkOut12 = PropertyElement.checkOut();
        checkOut12.setElementMap(elementMap);
        checkOut12.setName("preloading.isFailing");
        checkOut12.setAttribute("modulationColor");
        appearance5.addBasicElement(checkOut12);
        checkOut12.onAttributesInitialized();
        final ConditionResult element13 = new ConditionResult();
        element13.onCheckOut();
        element13.setElementMap(elementMap);
        element13.setValue("#FF888888");
        element13.setElseValue("#FFFFFFFF");
        checkOut12.addBasicElement(element13);
        element13.onAttributesInitialized();
        final TrueCondition element14 = new TrueCondition();
        element14.onCheckOut();
        element14.setElementMap(elementMap);
        element13.addBasicElement(element14);
        element14.onAttributesInitialized();
        element14.onChildrenAdded();
        element13.onChildrenAdded();
        checkOut12.onChildrenAdded();
        appearance5.onChildrenAdded();
        element11.onChildrenAdded();
        final ProgressBar element15 = new ProgressBar();
        element15.onCheckOut();
        element15.setElementMap(elementMap);
        element15.setStyle("preloading");
        element15.setPrefSize(new Dimension(48, 48));
        element15.setDisplayType(ProgressBar.ProgressBarDisplayType.CIRCLEDESAT);
        element15.setValue(1.0f);
        element15.setMinBound(0.0f);
        element15.setMaxBound(100.0f);
        element15.setNonBlocking(true);
        checkOut6.addBasicElement(element15);
        element15.onAttributesInitialized();
        final StaticLayoutData element16 = new StaticLayoutData();
        element16.onCheckOut();
        element16.setElementMap(elementMap);
        element16.setSize(new Dimension(-2, -2));
        element16.setAlign(Alignment17.CENTER);
        element15.addBasicElement(element16);
        element16.onAttributesInitialized();
        element16.onChildrenAdded();
        final DecoratorAppearance appearance6 = element15.getAppearance();
        appearance6.setElementMap(elementMap);
        element15.addBasicElement(appearance6);
        appearance6.onAttributesInitialized();
        final PlainBackground element17 = new PlainBackground();
        element17.onCheckOut();
        element17.setElementMap(elementMap);
        element17.setColor(new Color(1.0f, 0.0f, 0.0f, 0.0f));
        appearance6.addBasicElement(element17);
        element17.onAttributesInitialized();
        element17.onChildrenAdded();
        appearance6.onChildrenAdded();
        final PropertyElement checkOut13 = PropertyElement.checkOut();
        checkOut13.setElementMap(elementMap);
        checkOut13.setName("preloading.percent");
        checkOut13.setAttribute("value");
        element15.addBasicElement(checkOut13);
        checkOut13.onAttributesInitialized();
        checkOut13.onChildrenAdded();
        final PropertyElement checkOut14 = PropertyElement.checkOut();
        checkOut14.setElementMap(elementMap);
        checkOut14.setName("preloading.isFailing");
        checkOut14.setAttribute("visible");
        element15.addBasicElement(checkOut14);
        checkOut14.onAttributesInitialized();
        final ConditionResult element18 = new ConditionResult();
        element18.onCheckOut();
        element18.setElementMap(elementMap);
        checkOut14.addBasicElement(element18);
        element18.onAttributesInitialized();
        final FalseCondition element19 = new FalseCondition();
        element19.onCheckOut();
        element19.setElementMap(elementMap);
        element18.addBasicElement(element19);
        element19.onAttributesInitialized();
        element19.onChildrenAdded();
        element18.onChildrenAdded();
        checkOut14.onChildrenAdded();
        element15.onChildrenAdded();
        final TextView element20 = new TextView();
        element20.onCheckOut();
        element20.setElementMap(elementMap);
        element20.setStyle("SmallBoldBordered12");
        element20.setNonBlocking(true);
        checkOut6.addBasicElement(element20);
        element20.onAttributesInitialized();
        final StaticLayoutData element21 = new StaticLayoutData();
        element21.onCheckOut();
        element21.setElementMap(elementMap);
        element21.setSize(new Dimension(-2, -2));
        element21.setAlign(Alignment17.CENTER);
        element20.addBasicElement(element21);
        element21.onAttributesInitialized();
        element21.onChildrenAdded();
        final PropertyElement checkOut15 = PropertyElement.checkOut();
        checkOut15.setElementMap(elementMap);
        checkOut15.setName("preloading.percentText");
        checkOut15.setAttribute("text");
        element20.addBasicElement(checkOut15);
        checkOut15.onAttributesInitialized();
        checkOut15.onChildrenAdded();
        element20.onChildrenAdded();
        final RowLayoutData element22 = new RowLayoutData();
        element22.onCheckOut();
        element22.setElementMap(elementMap);
        element22.setAlign(Alignment9.NORTH);
        checkOut6.addBasicElement(element22);
        element22.onAttributesInitialized();
        element22.onChildrenAdded();
        final PropertyElement checkOut16 = PropertyElement.checkOut();
        checkOut16.setElementMap(elementMap);
        checkOut16.setName("preloading.isLoading");
        checkOut16.setAttribute("visible");
        checkOut6.addBasicElement(checkOut16);
        checkOut16.onAttributesInitialized();
        final ConditionResult element23 = new ConditionResult();
        element23.onCheckOut();
        element23.setElementMap(elementMap);
        checkOut16.addBasicElement(element23);
        element23.onAttributesInitialized();
        final AndCondition element24 = new AndCondition();
        element24.onCheckOut();
        element24.setElementMap(elementMap);
        element23.addBasicElement(element24);
        element24.onAttributesInitialized();
        final TrueCondition element25 = new TrueCondition();
        element25.onCheckOut();
        element25.setElementMap(elementMap);
        element24.addBasicElement(element25);
        element25.onAttributesInitialized();
        element25.onChildrenAdded();
        final FalseCondition element26 = new FalseCondition();
        element26.onCheckOut();
        element26.setElementMap(elementMap);
        element24.addBasicElement(element26);
        element26.onAttributesInitialized();
        final PropertyElement checkOut17 = PropertyElement.checkOut();
        checkOut17.setElementMap(elementMap);
        checkOut17.setAttribute("comparedValue");
        checkOut17.setName("isInGame");
        element26.addBasicElement(checkOut17);
        checkOut17.onAttributesInitialized();
        checkOut17.onChildrenAdded();
        element26.onChildrenAdded();
        element24.onChildrenAdded();
        element23.onChildrenAdded();
        checkOut16.onChildrenAdded();
        checkOut6.onChildrenAdded();
        checkOut.onChildrenAdded();
        return checkOut;
    }
}