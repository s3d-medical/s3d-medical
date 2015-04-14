jQuery.bt = {
    version: "0.9.5-rc1"
};
(function ($) {
    jQuery.fn.bt = function (content, options) {
        if (typeof content != "string") {
            var contentSelect = true;
            options = content;
            content = false
        } else {
            var contentSelect = false
        } if (jQuery.fn.hoverIntent && jQuery.bt.defaults.trigger == "hover") {
            jQuery.bt.defaults.trigger = "hoverIntent"
        }
        return this.each(function (index) {
            var opts = jQuery.extend(false, jQuery.bt.defaults, jQuery.bt.options, options);
            opts.spikeLength = numb(opts.spikeLength);
            opts.spikeGirth = numb(opts.spikeGirth);
            opts.overlap = numb(opts.overlap);
            var ajaxTimeout = false;
            if (opts.killTitle) {
                $(this).find("[title]").andSelf().each(function () {
                    if (!$(this).attr("bt-xTitle")) {
                        $(this).attr("bt-xTitle", $(this).attr("title")).attr("title", "")
                    }
                })
            }
            if (typeof opts.trigger == "string") {
                opts.trigger = [opts.trigger]
            }
            if (opts.trigger[0] == "hoverIntent") {
                var hoverOpts = jQuery.extend(opts.hoverIntentOpts, {
                    over: function () {
                        this.btOn()
                    },
                    out: function () {
                        this.btOff()
                    }
                });
                $(this).hoverIntent(hoverOpts)
            } else {
                if (opts.trigger[0] == "hover") {
                    $(this).hover(function () {
                        this.btOn()
                    }, function () {
                        this.btOff()
                    })
                } else {
                    if (opts.trigger[0] == "now") {
                        if ($(this).hasClass("bt-active")) {
                            this.btOff()
                        } else {
                            this.btOn()
                        }
                    } else {
                        if (opts.trigger[0] == "none") {} else {
                            if (opts.trigger.length > 1 && opts.trigger[0] != opts.trigger[1]) {
                                $(this).bind(opts.trigger[0], function () {
                                    this.btOn()
                                }).bind(opts.trigger[1], function () {
                                    this.btOff()
                                })
                            } else {
                                $(this).bind(opts.trigger[0], function () {
                                    if ($(this).hasClass("bt-active")) {
                                        this.btOff()
                                    } else {
                                        this.btOn()
                                    }
                                })
                            }
                        }
                    }
                }
            }
            this.btOn = function () {
                if (typeof $(this).data("bt-box") == "object") {
                    this.btOff()
                }
                opts.preBuild.apply(this);
                $(jQuery.bt.vars.closeWhenOpenStack).btOff();
                $(this).addClass("bt-active " + opts.activeClass);
                if (contentSelect && opts.ajaxPath == null) {
                    if (opts.killTitle) {
                        $(this).attr("title", $(this).attr("bt-xTitle"))
                    }
                    content = $.isFunction(opts.contentSelector) ? opts.contentSelector.apply(this) : eval(opts.contentSelector);
                    if (opts.killTitle) {
                        $(this).attr("title", "")
                    }
                }
                if (opts.ajaxPath != null && content == false) {
                    if (typeof opts.ajaxPath == "object") {
                        var url = eval(opts.ajaxPath[0]);
                        url += opts.ajaxPath[1] ? " " + opts.ajaxPath[1] : ""
                    } else {
                        var url = opts.ajaxPath
                    }
                    var off = url.indexOf(" ");
                    if (off >= 0) {
                        var selector = url.slice(off, url.length);
                        url = url.slice(0, off)
                    }
                    var cacheData = opts.ajaxCache ? $(document.body).data("btCache-" + url.replace(/\./g, "")) : null;
                    if (typeof cacheData == "string") {
                        content = selector ? $("<div/>").append(cacheData.replace(/<script(.|\s)*?\/script>/g, "")).find(selector) : cacheData
                    } else {
                        var target = this;
                        var ajaxOpts = jQuery.extend(false, {
                            type: opts.ajaxType,
                            data: opts.ajaxData,
                            cache: opts.ajaxCache,
                            url: url,
                            complete: function (XMLHttpRequest, textStatus) {
                                if (textStatus == "success" || textStatus == "notmodified") {
                                    if (opts.ajaxCache) {
                                        $(document.body).data("btCache-" + url.replace(/\./g, ""), XMLHttpRequest.responseText)
                                    }
                                    ajaxTimeout = false;
                                    content = selector ? $("<div/>").append(XMLHttpRequest.responseText.replace(/<script(.|\s)*?\/script>/g, "")).find(selector) : XMLHttpRequest.responseText
                                } else {
                                    if (textStatus == "timeout") {
                                        ajaxTimeout = true
                                    }
                                    content = opts.ajaxError.replace(/%error/g, XMLHttpRequest.statusText)
                                } if ($(target).hasClass("bt-active")) {
                                    target.btOn()
                                }
                            }
                        }, opts.ajaxOpts);
                        jQuery.ajax(ajaxOpts);
                        content = opts.ajaxLoading
                    }
                }
                var shadowMarginX = 0;
                var shadowMarginY = 0;
                var shadowShiftX = 0;
                var shadowShiftY = 0;
                if (opts.shadow && !shadowSupport()) {
                    opts.shadow = false;
                    jQuery.extend(opts, opts.noShadowOpts)
                }
                if (opts.shadow) {
                    if (opts.shadowBlur > Math.abs(opts.shadowOffsetX)) {
                        shadowMarginX = opts.shadowBlur * 2
                    } else {
                        shadowMarginX = opts.shadowBlur + Math.abs(opts.shadowOffsetX)
                    }
                    shadowShiftX = (opts.shadowBlur - opts.shadowOffsetX) > 0 ? opts.shadowBlur - opts.shadowOffsetX : 0;
                    if (opts.shadowBlur > Math.abs(opts.shadowOffsetY)) {
                        shadowMarginY = opts.shadowBlur * 2
                    } else {
                        shadowMarginY = opts.shadowBlur + Math.abs(opts.shadowOffsetY)
                    }
                    shadowShiftY = (opts.shadowBlur - opts.shadowOffsetY) > 0 ? opts.shadowBlur - opts.shadowOffsetY : 0
                }
                if (opts.offsetParent) {
                    var offsetParent = $(opts.offsetParent);
                    var offsetParentPos = offsetParent.offset();
                    var pos = $(this).offset();
                    var top = numb(pos.top) - numb(offsetParentPos.top) + numb($(this).css("margin-top")) - shadowShiftY;
                    var left = numb(pos.left) - numb(offsetParentPos.left) + numb($(this).css("margin-left")) - shadowShiftX
                } else {
                    var offsetParent = ($(this).css("position") == "absolute") ? $(this).parents().eq(0).offsetParent() : $(this).offsetParent();
                    var pos = $(this).btPosition();
                    var top = numb(pos.top) + numb($(this).css("margin-top")) - shadowShiftY;
                    var left = numb(pos.left) + numb($(this).css("margin-left")) - shadowShiftX
                }
                var width = $(this).btOuterWidth();
                var height = $(this).outerHeight();
                if (typeof content == "object") {
                    var original = content;
                    var clone = $(original).clone(true).show();
                    var origClones = $(original).data("bt-clones") || [];
                    origClones.push(clone);
                    $(original).data("bt-clones", origClones);
                    $(clone).data("bt-orig", original);
                    $(this).data("bt-content-orig", {
                        original: original,
                        clone: clone
                    });
                    content = clone
                }
                if (typeof content == "null" || content == "") {
                    return
                }
                var $text = $('<div class="bt-content"></div>').append(content).css({
                    padding: opts.padding,
                    position: "absolute",
                    width: (opts.shrinkToFit ? "auto" : opts.width),
                    zIndex: opts.textzIndex,
                    left: shadowShiftX,
                    top: shadowShiftY
                }).css(opts.cssStyles);
                var $box = $('<div class="bt-wrapper"></div>').append($text).addClass(opts.cssClass).css({
                    position: "absolute",
                    width: opts.width,
                    zIndex: opts.wrapperzIndex,
                    visibility: "hidden"
                }).appendTo(offsetParent);
                if (jQuery.fn.bgiframe) {
                    $text.bgiframe();
                    $box.bgiframe()
                }
                $(this).data("bt-box", $box);
                var scrollTop = numb($(document).scrollTop());
                var scrollLeft = numb($(document).scrollLeft());
                var docWidth = numb($(window).width());
                var docHeight = numb($(window).height());
                var winRight = scrollLeft + docWidth;
                var winBottom = scrollTop + docHeight;
                var space = new Object();
                var thisOffset = $(this).offset();
                space.top = thisOffset.top - scrollTop;
                space.bottom = docHeight - ((thisOffset + height) - scrollTop);
                space.left = thisOffset.left - scrollLeft;
                space.right = docWidth - ((thisOffset.left + width) - scrollLeft);
                var textOutHeight = numb($text.outerHeight());
                var textOutWidth = numb($text.btOuterWidth());
                if (opts.positions.constructor == String) {
                    opts.positions = opts.positions.replace(/ /, "").split(",")
                }
                if (opts.positions[0] == "most") {
                    var position = "top";
                    for (var pig in space) {
                        position = space[pig] > space[position] ? pig : position
                    }
                } else {
                    for (var i = 0; i < opts.positions.length; i++) {
                        var position = opts.positions[i];
                        if ((position == "left" || position == "right") && space[position] > textOutWidth + opts.spikeLength) {
                            break
                        } else {
                            if ((position == "top" || position == "bottom") && space[position] > textOutHeight + opts.spikeLength) {
                                break
                            }
                        }
                    }
                }
                var horiz = left + ((width - textOutWidth) * 0.5);
                var vert = top + ((height - textOutHeight) * 0.5);
                var points = new Array();
                var textTop, textLeft, textRight, textBottom, textTopSpace, textBottomSpace, textLeftSpace, textRightSpace, crossPoint, textCenter, spikePoint;
                switch (position) {
                case "top":
                    $text.css("margin-bottom", opts.spikeLength + "px");
                    $box.css({
                        top: (top - $text.outerHeight(true)) + opts.overlap,
                        left: horiz
                    });
                    textRightSpace = (winRight - opts.windowMargin) - ($text.offset().left + $text.btOuterWidth(true));
                    var xShift = shadowShiftX;
                    if (textRightSpace < 0) {
                        $box.css("left", (numb($box.css("left")) + textRightSpace) + "px");
                        xShift -= textRightSpace
                    }
                    textLeftSpace = ($text.offset().left + numb($text.css("margin-left"))) - (scrollLeft + opts.windowMargin);
                    if (textLeftSpace < 0) {
                        $box.css("left", (numb($box.css("left")) - textLeftSpace) + "px");
                        xShift += textLeftSpace
                    }
                    textTop = $text.btPosition().top + numb($text.css("margin-top"));
                    textLeft = $text.btPosition().left + numb($text.css("margin-left"));
                    textRight = textLeft + $text.btOuterWidth();
                    textBottom = textTop + $text.outerHeight();
                    textCenter = {
                        x: textLeft + ($text.btOuterWidth() * opts.centerPointX),
                        y: textTop + ($text.outerHeight() * opts.centerPointY)
                    };
                    points[points.length] = spikePoint = {
                        y: textBottom + opts.spikeLength,
                        x: ((textRight - textLeft) * 0.5) + xShift,
                        type: "spike"
                    };
                    crossPoint = findIntersectX(spikePoint.x, spikePoint.y, textCenter.x, textCenter.y, textBottom);
                    crossPoint.x = crossPoint.x < textLeft + opts.spikeGirth / 2 + opts.cornerRadius ? textLeft + opts.spikeGirth / 2 + opts.cornerRadius : crossPoint.x;
                    crossPoint.x = crossPoint.x > (textRight - opts.spikeGirth / 2) - opts.cornerRadius ? (textRight - opts.spikeGirth / 2) - opts.CornerRadius : crossPoint.x;
                    points[points.length] = {
                        x: crossPoint.x - (opts.spikeGirth / 2),
                        y: textBottom,
                        type: "join"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: crossPoint.x + (opts.spikeGirth / 2),
                        y: textBottom,
                        type: "join"
                    };
                    points[points.length] = spikePoint;
                    break;
                case "left":
                    $text.css("margin-right", opts.spikeLength + "px");
                    $box.css({
                        top: vert + "px",
                        left: ((left - $text.btOuterWidth(true)) + opts.overlap) + "px"
                    });
                    textBottomSpace = (winBottom - opts.windowMargin) - ($text.offset().top + $text.outerHeight(true));
                    var yShift = shadowShiftY;
                    if (textBottomSpace < 0) {
                        $box.css("top", (numb($box.css("top")) + textBottomSpace) + "px");
                        yShift -= textBottomSpace
                    }
                    textTopSpace = ($text.offset().top + numb($text.css("margin-top"))) - (scrollTop + opts.windowMargin);
                    if (textTopSpace < 0) {
                        $box.css("top", (numb($box.css("top")) - textTopSpace) + "px");
                        yShift += textTopSpace
                    }
                    textTop = $text.btPosition().top + numb($text.css("margin-top"));
                    textLeft = $text.btPosition().left + numb($text.css("margin-left"));
                    textRight = textLeft + $text.btOuterWidth();
                    textBottom = textTop + $text.outerHeight();
                    textCenter = {
                        x: textLeft + ($text.btOuterWidth() * opts.centerPointX),
                        y: textTop + ($text.outerHeight() * opts.centerPointY)
                    };
                    points[points.length] = spikePoint = {
                        x: textRight + opts.spikeLength,
                        y: ((textBottom - textTop) * 0.5) + yShift,
                        type: "spike"
                    };
                    crossPoint = findIntersectY(spikePoint.x, spikePoint.y, textCenter.x, textCenter.y, textRight);
                    crossPoint.y = crossPoint.y < textTop + opts.spikeGirth / 2 + opts.cornerRadius ? textTop + opts.spikeGirth / 2 + opts.cornerRadius : crossPoint.y;
                    crossPoint.y = crossPoint.y > (textBottom - opts.spikeGirth / 2) - opts.cornerRadius ? (textBottom - opts.spikeGirth / 2) - opts.cornerRadius : crossPoint.y;
                    points[points.length] = {
                        x: textRight,
                        y: crossPoint.y + opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: crossPoint.y - opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = spikePoint;
                    break;
                case "left-top-spike":
                    var attachPointOffset = opts.attachPointOffset;
                    $text.css("margin-right", opts.spikeLength + "px");
                    vert = attachPointOffset.top - (attachPointOffset.top * 0.1);
                    $box.css({
                        top: vert + "px",
                        left: ((left - $text.btOuterWidth(true)) + opts.overlap) + "px"
                    });
                    textBottomSpace = (winBottom - opts.windowMargin) - ($text.offset().top + $text.outerHeight(true));
                    var yShift = shadowShiftY;
                    if (textBottomSpace < 0) {
                        $box.css("top", (numb($box.css("top")) + textBottomSpace) + "px");
                        yShift -= textBottomSpace
                    }
                    textTopSpace = ($text.offset().top + numb($text.css("margin-top"))) - (scrollTop + opts.windowMargin);
                    if (textTopSpace < 0) {
                        $box.css("top", (numb($box.css("top")) - textTopSpace) + "px");
                        yShift += textTopSpace
                    }
                    textTop = $text.btPosition().top + numb($text.css("margin-top"));
                    textLeft = $text.btPosition().left + numb($text.css("margin-left"));
                    textRight = textLeft + $text.btOuterWidth();
                    textBottom = textTop + $text.outerHeight();
                    textCenter = {
                        x: textLeft + ($text.btOuterWidth() * opts.centerPointX),
                        y: textTop + ($text.outerHeight() * opts.centerPointY)
                    };
                    points[points.length] = spikePoint = {
                        x: textRight + opts.spikeLength,
                        y: ((textBottom - textTop) * 0.1) + yShift,
                        type: "spike"
                    };
                    crossPoint = findIntersectY(spikePoint.x, spikePoint.y, textCenter.x, textCenter.y, textRight);
                    crossPoint.y = crossPoint.y < textTop + opts.spikeGirth / 2 + opts.cornerRadius ? textTop + opts.spikeGirth / 2 + opts.cornerRadius : crossPoint.y;
                    crossPoint.y = crossPoint.y > (textBottom - opts.spikeGirth / 2) - opts.cornerRadius ? (textBottom - opts.spikeGirth / 2) - opts.cornerRadius : crossPoint.y;
                    points[points.length] = {
                        x: textRight,
                        y: crossPoint.y + opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: crossPoint.y - opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = spikePoint;
                    break;
                case "bottom":
                    $text.css("margin-top", opts.spikeLength + "px");
                    $box.css({
                        top: (top + height) - opts.overlap,
                        left: horiz
                    });
                    textRightSpace = (winRight - opts.windowMargin) - ($text.offset().left + $text.btOuterWidth(true));
                    var xShift = shadowShiftX;
                    if (textRightSpace < 0) {
                        $box.css("left", (numb($box.css("left")) + textRightSpace) + "px");
                        xShift -= textRightSpace
                    }
                    textLeftSpace = ($text.offset().left + numb($text.css("margin-left"))) - (scrollLeft + opts.windowMargin);
                    if (textLeftSpace < 0) {
                        $box.css("left", (numb($box.css("left")) - textLeftSpace) + "px");
                        xShift += textLeftSpace
                    }
                    textTop = $text.btPosition().top + numb($text.css("margin-top"));
                    textLeft = $text.btPosition().left + numb($text.css("margin-left"));
                    textRight = textLeft + $text.btOuterWidth();
                    textBottom = textTop + $text.outerHeight();
                    textCenter = {
                        x: textLeft + ($text.btOuterWidth() * opts.centerPointX),
                        y: textTop + ($text.outerHeight() * opts.centerPointY)
                    };
                    points[points.length] = spikePoint = {
                        x: ((textRight - textLeft) * 0.5) + xShift,
                        y: shadowShiftY,
                        type: "spike"
                    };
                    crossPoint = findIntersectX(spikePoint.x, spikePoint.y, textCenter.x, textCenter.y, textTop);
                    crossPoint.x = crossPoint.x < textLeft + opts.spikeGirth / 2 + opts.cornerRadius ? textLeft + opts.spikeGirth / 2 + opts.cornerRadius : crossPoint.x;
                    crossPoint.x = crossPoint.x > (textRight - opts.spikeGirth / 2) - opts.cornerRadius ? (textRight - opts.spikeGirth / 2) - opts.cornerRadius : crossPoint.x;
                    points[points.length] = {
                        x: crossPoint.x + opts.spikeGirth / 2,
                        y: textTop,
                        type: "join"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: crossPoint.x - (opts.spikeGirth / 2),
                        y: textTop,
                        type: "join"
                    };
                    points[points.length] = spikePoint;
                    break;
                case "right":
                    $text.css("margin-left", (opts.spikeLength + "px"));
                    $box.css({
                        top: vert + "px",
                        left: ((left + width) - opts.overlap) + "px"
                    });
                    textBottomSpace = (winBottom - opts.windowMargin) - ($text.offset().top + $text.outerHeight(true));
                    var yShift = shadowShiftY;
                    if (textBottomSpace < 0) {
                        $box.css("top", (numb($box.css("top")) + textBottomSpace) + "px");
                        yShift -= textBottomSpace
                    }
                    textTopSpace = ($text.offset().top + numb($text.css("margin-top"))) - (scrollTop + opts.windowMargin);
                    if (textTopSpace < 0) {
                        $box.css("top", (numb($box.css("top")) - textTopSpace) + "px");
                        yShift += textTopSpace
                    }
                    textTop = $text.btPosition().top + numb($text.css("margin-top"));
                    textLeft = $text.btPosition().left + numb($text.css("margin-left"));
                    textRight = textLeft + $text.btOuterWidth();
                    textBottom = textTop + $text.outerHeight();
                    textCenter = {
                        x: textLeft + ($text.btOuterWidth() * opts.centerPointX),
                        y: textTop + ($text.outerHeight() * opts.centerPointY)
                    };
                    points[points.length] = spikePoint = {
                        x: shadowShiftX,
                        y: ((textBottom - textTop) * 0.5) + yShift,
                        type: "spike"
                    };
                    crossPoint = findIntersectY(spikePoint.x, spikePoint.y, textCenter.x, textCenter.y, textLeft);
                    crossPoint.y = crossPoint.y < textTop + opts.spikeGirth / 2 + opts.cornerRadius ? textTop + opts.spikeGirth / 2 + opts.cornerRadius : crossPoint.y;
                    crossPoint.y = crossPoint.y > (textBottom - opts.spikeGirth / 2) - opts.cornerRadius ? (textBottom - opts.spikeGirth / 2) - opts.cornerRadius : crossPoint.y;
                    points[points.length] = {
                        x: textLeft,
                        y: crossPoint.y - opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textTop,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textRight,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: textBottom,
                        type: "corner"
                    };
                    points[points.length] = {
                        x: textLeft,
                        y: crossPoint.y + opts.spikeGirth / 2,
                        type: "join"
                    };
                    points[points.length] = spikePoint;
                    break
                }
                var canvas = document.createElement("canvas");
                $(canvas).attr("width", (numb($text.btOuterWidth(true)) + opts.strokeWidth * 2 + shadowMarginX)).attr("height", (numb($text.outerHeight(true)) + opts.strokeWidth * 2 + shadowMarginY)).appendTo($box).css({
                    position: "absolute",
                    zIndex: opts.boxzIndex
                });
                if (typeof G_vmlCanvasManager != "undefined") {
                    canvas = G_vmlCanvasManager.initElement(canvas)
                }
                if (opts.cornerRadius > 0) {
                    var newPoints = new Array();
                    var newPoint;
                    for (var i = 0; i < points.length; i++) {
                        if (points[i].type == "corner") {
                            newPoint = betweenPoint(points[i], points[(i - 1) % points.length], opts.cornerRadius);
                            newPoint.type = "arcStart";
                            newPoints[newPoints.length] = newPoint;
                            newPoints[newPoints.length] = points[i];
                            newPoint = betweenPoint(points[i], points[(i + 1) % points.length], opts.cornerRadius);
                            newPoint.type = "arcEnd";
                            newPoints[newPoints.length] = newPoint
                        } else {
                            newPoints[newPoints.length] = points[i]
                        }
                    }
                    points = newPoints
                }
                var ctx = canvas.getContext("2d");
                if (opts.shadow && opts.shadowOverlap !== true) {
                    var shadowOverlap = numb(opts.shadowOverlap);
                    switch (position) {
                    case "top":
                        if (opts.shadowOffsetX + opts.shadowBlur - shadowOverlap > 0) {
                            $box.css("top", (numb($box.css("top")) - (opts.shadowOffsetX + opts.shadowBlur - shadowOverlap)))
                        }
                        break;
                    case "right":
                        if (shadowShiftX - shadowOverlap > 0) {
                            $box.css("left", (numb($box.css("left")) + shadowShiftX - shadowOverlap))
                        }
                        break;
                    case "bottom":
                        if (shadowShiftY - shadowOverlap > 0) {
                            $box.css("top", (numb($box.css("top")) + shadowShiftY - shadowOverlap))
                        }
                        break;
                    case "left":
                        if (opts.shadowOffsetY + opts.shadowBlur - shadowOverlap > 0) {
                            $box.css("left", (numb($box.css("left")) - (opts.shadowOffsetY + opts.shadowBlur - shadowOverlap)))
                        }
                        break
                    }
                }
                drawIt.apply(ctx, [points], opts.strokeWidth);
                ctx.fillStyle = opts.fill;
                if (opts.shadow) {
                    ctx.shadowOffsetX = opts.shadowOffsetX;
                    ctx.shadowOffsetY = opts.shadowOffsetY;
                    ctx.shadowBlur = opts.shadowBlur;
                    ctx.shadowColor = opts.shadowColor
                }
                ctx.closePath();
                ctx.fill();
                if (opts.strokeWidth > 0) {
                    ctx.shadowColor = "rgba(0, 0, 0, 0)";
                    ctx.lineWidth = opts.strokeWidth;
                    ctx.strokeStyle = opts.strokeStyle;
                    ctx.beginPath();
                    drawIt.apply(ctx, [points], opts.strokeWidth);
                    ctx.closePath();
                    ctx.stroke()
                }
                opts.preShow.apply(this, [$box[0]]);
                $box.css({
                    display: "none",
                    visibility: "visible"
                });
                opts.showTip.apply(this, [$box[0]]);
                if (opts.overlay) {
                    var overlay = $('<div class="bt-overlay"></div>').css({
                        position: "absolute",
                        backgroundColor: "blue",
                        top: top,
                        left: left,
                        width: width,
                        height: height,
                        opacity: ".2"
                    }).appendTo(offsetParent);
                    $(this).data("overlay", overlay)
                }
                if ((opts.ajaxPath != null && opts.ajaxCache == false) || ajaxTimeout) {
                    content = false
                }
                if (opts.clickAnywhereToClose) {
                    jQuery.bt.vars.clickAnywhereStack.push(this);
                    $(document).click(jQuery.bt.docClick)
                }
                if (opts.closeWhenOthersOpen) {
                    jQuery.bt.vars.closeWhenOpenStack.push(this)
                }
                opts.postShow.apply(this, [$box[0]])
            };
            this.btOff = function () {
                var box = $(this).data("bt-box");
                opts.preHide.apply(this, [box]);
                var i = this;
                i.btCleanup = function () {
                    var box = $(i).data("bt-box");
                    var contentOrig = $(i).data("bt-content-orig");
                    var overlay = $(i).data("bt-overlay");
                    if (typeof box == "object") {
                        var parent = $(box).parent();
                        parent[0].removeChild(box[0]);
                        $(i).removeData("bt-box")
                    }
                    if (typeof contentOrig == "object") {
                        var clones = $(contentOrig.original).data("bt-clones");
                        $(contentOrig).data("bt-clones", arrayRemove(clones, contentOrig.clone))
                    }
                    if (typeof overlay == "object") {
                        $(overlay).remove();
                        $(i).removeData("bt-overlay")
                    }
                    jQuery.bt.vars.clickAnywhereStack = arrayRemove(jQuery.bt.vars.clickAnywhereStack, i);
                    jQuery.bt.vars.closeWhenOpenStack = arrayRemove(jQuery.bt.vars.closeWhenOpenStack, i);
                    $(i).removeClass("bt-active " + opts.activeClass);
                    opts.postHide.apply(i)
                };
                opts.hideTip.apply(this, [box, i.btCleanup])
            };
            var refresh = this.btRefresh = function () {
                this.btOff();
                this.btOn()
            }
        });

        function drawIt(points, strokeWidth) {
            this.moveTo(points[0].x, points[0].y);
            for (i = 1; i < points.length; i++) {
                if (points[i - 1].type == "arcStart") {
                    this.quadraticCurveTo(round5(points[i].x, strokeWidth), round5(points[i].y, strokeWidth), round5(points[(i + 1) % points.length].x, strokeWidth), round5(points[(i + 1) % points.length].y, strokeWidth));
                    i++
                } else {
                    this.lineTo(round5(points[i].x, strokeWidth), round5(points[i].y, strokeWidth))
                }
            }
        }

        function round5(num, strokeWidth) {
            var ret;
            strokeWidth = numb(strokeWidth);
            if (strokeWidth % 2) {
                ret = num
            } else {
                ret = Math.round(num - 0.5) + 0.5
            }
            return ret
        }

        function numb(num) {
            return parseInt(num) || 0
        }

        function arrayRemove(arr, elem) {
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] == elem) {
                    arr.splice(i, 1)
                }
            }
            return arr
        }

        function canvasSupport() {
            var canvas_compatible = false;
            try {
                canvas_compatible = !! (document.createElement("canvas").getContext("2d"))
            } catch (e) {
                canvas_compatible = !! (document.createElement("canvas").getContext)
            }
            return canvas_compatible
        }

        function shadowSupport() {
            try {
                var userAgent = navigator.userAgent.toLowerCase();
                if (/webkit/.test(userAgent)) {
                    return true
                } else {
                    if (/gecko|mozilla/.test(userAgent) && parseFloat(userAgent.match(/firefox\/(\d+(?:\.\d+)+)/)[1]) >= 3.1) {
                        return true
                    }
                }
            } catch (err) {}
            return false
        }

        function betweenPoint(point1, point2, dist) {
            var y, x;
            if (point1.x == point2.x) {
                y = point1.y < point2.y ? point1.y + dist : point1.y - dist;
                return {
                    x: point1.x,
                    y: y
                }
            } else {
                if (point1.y == point2.y) {
                    x = point1.x < point2.x ? point1.x + dist : point1.x - dist;
                    return {
                        x: x,
                        y: point1.y
                    }
                }
            }
        }

        function centerPoint(arcStart, corner, arcEnd) {
            var x = corner.x == arcStart.x ? arcEnd.x : arcStart.x;
            var y = corner.y == arcStart.y ? arcEnd.y : arcStart.y;
            var startAngle, endAngle;
            if (arcStart.x < arcEnd.x) {
                if (arcStart.y > arcEnd.y) {
                    startAngle = (Math.PI / 180) * 180;
                    endAngle = (Math.PI / 180) * 90
                } else {
                    startAngle = (Math.PI / 180) * 90;
                    endAngle = 0
                }
            } else {
                if (arcStart.y > arcEnd.y) {
                    startAngle = (Math.PI / 180) * 270;
                    endAngle = (Math.PI / 180) * 180
                } else {
                    startAngle = 0;
                    endAngle = (Math.PI / 180) * 270
                }
            }
            return {
                x: x,
                y: y,
                type: "center",
                startAngle: startAngle,
                endAngle: endAngle
            }
        }

        function findIntersect(r1x1, r1y1, r1x2, r1y2, r2x1, r2y1, r2x2, r2y2) {
            if (r2x1 == r2x2) {
                return findIntersectY(r1x1, r1y1, r1x2, r1y2, r2x1)
            }
            if (r2y1 == r2y2) {
                return findIntersectX(r1x1, r1y1, r1x2, r1y2, r2y1)
            }
            var r1m = (r1y1 - r1y2) / (r1x1 - r1x2);
            var r1b = r1y1 - (r1m * r1x1);
            var r2m = (r2y1 - r2y2) / (r2x1 - r2x2);
            var r2b = r2y1 - (r2m * r2x1);
            var x = (r2b - r1b) / (r1m - r2m);
            var y = r1m * x + r1b;
            return {
                x: x,
                y: y
            }
        }

        function findIntersectY(r1x1, r1y1, r1x2, r1y2, x) {
            if (r1y1 == r1y2) {
                return {
                    x: x,
                    y: r1y1
                }
            }
            var r1m = (r1y1 - r1y2) / (r1x1 - r1x2);
            var r1b = r1y1 - (r1m * r1x1);
            var y = r1m * x + r1b;
            return {
                x: x,
                y: y
            }
        }

        function findIntersectX(r1x1, r1y1, r1x2, r1y2, y) {
            if (r1x1 == r1x2) {
                return {
                    x: r1x1,
                    y: y
                }
            }
            var r1m = (r1y1 - r1y2) / (r1x1 - r1x2);
            var r1b = r1y1 - (r1m * r1x1);
            var x = (y - r1b) / r1m;
            return {
                x: x,
                y: y
            }
        }
    };
    jQuery.fn.btPosition = function () {
        function num(elem, prop) {
            return elem[0] && parseInt(jQuery.curCSS(elem[0], prop, true), 10) || 0
        }
        var left = 0,
            top = 0,
            results;
        if (this[0]) {
            var offsetParent = this.offsetParent(),
                offset = this.offset(),
                parentOffset = /^body|html$/i.test(offsetParent[0].tagName) ? {
                    top: 0,
                    left: 0
                } : offsetParent.offset();
            offset.top -= num(this, "marginTop");
            offset.left -= num(this, "marginLeft");
            parentOffset.top += num(offsetParent, "borderTopWidth");
            parentOffset.left += num(offsetParent, "borderLeftWidth");
            results = {
                top: offset.top - parentOffset.top,
                left: offset.left - parentOffset.left
            }
        }
        return results
    };
    jQuery.fn.btOuterWidth = function (margin) {
        function num(elem, prop) {
            return elem[0] && parseInt(jQuery.curCSS(elem[0], prop, true), 10) || 0
        }
        return this["innerWidth"]() + num(this, "borderLeftWidth") + num(this, "borderRightWidth") + (margin ? num(this, "marginLeft") + num(this, "marginRight") : 0)
    };
    jQuery.fn.btOn = function () {
        return this.each(function (index) {
            if (jQuery.isFunction(this.btOn)) {
                this.btOn()
            }
        })
    };
    jQuery.fn.btOff = function () {
        return this.each(function (index) {
            if (jQuery.isFunction(this.btOff)) {
                this.btOff()
            }
        })
    };
    jQuery.bt.vars = {
        clickAnywhereStack: [],
        closeWhenOpenStack: []
    };
    jQuery.bt.docClick = function (e) {
        if (!e) {
            var e = window.event
        }
        if (!$(e.target).parents().andSelf().filter(".bt-wrapper, .bt-active").length && jQuery.bt.vars.clickAnywhereStack.length) {
            $(jQuery.bt.vars.clickAnywhereStack).btOff();
            $(document).unbind("click", jQuery.bt.docClick)
        }
    };
    jQuery.bt.defaults = {
        trigger: "hover",
        clickAnywhereToClose: true,
        closeWhenOthersOpen: false,
        shrinkToFit: false,
        width: "200px",
        padding: "10px",
        spikeGirth: 10,
        spikeLength: 15,
        overlap: 0,
        overlay: false,
        killTitle: true,
        textzIndex: 9999,
        boxzIndex: 9998,
        wrapperzIndex: 9997,
        offsetParent: null,
        positions: ["most"],
        fill: "rgb(255, 255, 102)",
        windowMargin: 10,
        strokeWidth: 1,
        strokeStyle: "#000",
        cornerRadius: 5,
        centerPointX: 0.5,
        centerPointY: 0.5,
        attachPointOffset: {},
        shadow: false,
        shadowOffsetX: 2,
        shadowOffsetY: 2,
        shadowBlur: 3,
        shadowColor: "#000",
        shadowOverlap: false,
        noShadowOpts: {
            strokeStyle: "#999"
        },
        cssClass: "",
        cssStyles: {},
        activeClass: "bt-active",
        contentSelector: "$(this).attr('title')",
        ajaxPath: null,
        ajaxError: "<strong>ERROR:</strong> <em>%error</em>",
        ajaxLoading: "<blink>Loading...</blink>",
        ajaxData: {},
        ajaxType: "GET",
        ajaxCache: true,
        ajaxOpts: {},
        preBuild: function () {},
        preShow: function (box) {},
        showTip: function (box) {
            $(box).show()
        },
        postShow: function (box) {},
        preHide: function (box) {},
        hideTip: function (box, callback) {
            $(box).hide();
            callback()
        },
        postHide: function () {},
        hoverIntentOpts: {
            interval: 300,
            timeout: 500
        }
    };
    jQuery.bt.options = {}
})(jQuery);
if (!document.createElement("canvas").getContext) {
    (function () {
        var I = Math;
        var H = I.round;
        var N = I.sin;
        var M = I.cos;
        var W = I.abs;
        var O = I.sqrt;
        var ag = 10;
        var V = ag / 2;

        function Z() {
            return this.context_ || (this.context_ = new S(this))
        }
        var K = Array.prototype.slice;

        function J(b, a, d) {
            var c = K.call(arguments, 2);
            return function () {
                return b.apply(a, c.concat(K.call(arguments)))
            }
        }
        var Y = {
            init: function (b) {
                if (/MSIE/.test(navigator.userAgent) && !window.opera) {
                    var a = b || document;
                    a.createElement("canvas");
                    a.attachEvent("onreadystatechange", J(this.init_, this, a))
                }
            },
            init_: function (c) {
                if (!c.namespaces.g_vml_) {
                    c.namespaces.add("g_vml_", "urn:schemas-microsoft-com:vml", "#default#VML")
                }
                if (!c.namespaces.g_o_) {
                    c.namespaces.add("g_o_", "urn:schemas-microsoft-com:office:office", "#default#VML")
                }
                if (!c.styleSheets.ex_canvas_) {
                    var d = c.createStyleSheet();
                    d.owningElement.id = "ex_canvas_";
                    d.cssText = "canvas{display:inline-block;overflow:hidden;text-align:left;width:300px;height:150px}g_vml_\\:*{behavior:url(#default#VML)}g_o_\\:*{behavior:url(#default#VML)}"
                }
                var a = c.getElementsByTagName("canvas");
                for (var b = 0; b < a.length; b++) {
                    this.initElement(a[b])
                }
            },
            initElement: function (a) {
                if (!a.getContext) {
                    a.getContext = Z;
                    a.innerHTML = "";
                    a.attachEvent("onpropertychange", Q);
                    a.attachEvent("onresize", af);
                    var b = a.attributes;
                    if (b.width && b.width.specified) {
                        a.style.width = b.width.nodeValue + "px"
                    } else {
                        a.width = a.clientWidth
                    } if (b.height && b.height.specified) {
                        a.style.height = b.height.nodeValue + "px"
                    } else {
                        a.height = a.clientHeight
                    }
                }
                return a
            }
        };

        function Q(a) {
            var b = a.srcElement;
            switch (a.propertyName) {
            case "width":
                b.style.width = b.attributes.width.nodeValue + "px";
                b.getContext().clearRect();
                break;
            case "height":
                b.style.height = b.attributes.height.nodeValue + "px";
                b.getContext().clearRect();
                break
            }
        }

        function af(a) {
            var b = a.srcElement;
            if (b.firstChild) {
                b.firstChild.style.width = b.clientWidth + "px";
                b.firstChild.style.height = b.clientHeight + "px"
            }
        }
        Y.init();
        var ac = [];
        for (var j = 0; j < 16; j++) {
            for (var m = 0; m < 16; m++) {
                ac[j * 16 + m] = j.toString(16) + m.toString(16)
            }
        }

        function P() {
            return [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        }

        function ad(g, a) {
            var d = P();
            for (var f = 0; f < 3; f++) {
                for (var b = 0; b < 3; b++) {
                    var e = 0;
                    for (var c = 0; c < 3; c++) {
                        e += g[f][c] * a[c][b]
                    }
                    d[f][b] = e
                }
            }
            return d
        }

        function G(a, b) {
            b.fillStyle = a.fillStyle;
            b.lineCap = a.lineCap;
            b.lineJoin = a.lineJoin;
            b.lineWidth = a.lineWidth;
            b.miterLimit = a.miterLimit;
            b.shadowBlur = a.shadowBlur;
            b.shadowColor = a.shadowColor;
            b.shadowOffsetX = a.shadowOffsetX;
            b.shadowOffsetY = a.shadowOffsetY;
            b.strokeStyle = a.strokeStyle;
            b.globalAlpha = a.globalAlpha;
            b.arcScaleX_ = a.arcScaleX_;
            b.arcScaleY_ = a.arcScaleY_;
            b.lineScale_ = a.lineScale_
        }

        function ae(a) {
            var e, f = 1;
            a = String(a);
            if (a.substring(0, 3) == "rgb") {
                var b = a.indexOf("(", 3);
                var d = a.indexOf(")", b + 1);
                var c = a.substring(b + 1, d).split(",");
                e = "#";
                for (var g = 0; g < 3; g++) {
                    e += ac[Number(c[g])]
                }
                if (c.length == 4 && a.substr(3, 1) == "a") {
                    f = c[3]
                }
            } else {
                e = a
            }
            return {
                color: e,
                alpha: f
            }
        }

        function L(a) {
            switch (a) {
            case "butt":
                return "flat";
            case "round":
                return "round";
            case "square":
            default:
                return "square"
            }
        }

        function S(a) {
            this.m_ = P();
            this.mStack_ = [];
            this.aStack_ = [];
            this.currentPath_ = [];
            this.strokeStyle = "#000";
            this.fillStyle = "#000";
            this.lineWidth = 1;
            this.lineJoin = "miter";
            this.lineCap = "butt";
            this.miterLimit = ag * 1;
            this.globalAlpha = 1;
            this.canvas = a;
            var b = a.ownerDocument.createElement("div");
            b.style.width = a.clientWidth + "px";
            b.style.height = a.clientHeight + "px";
            b.style.overflow = "hidden";
            b.style.position = "absolute";
            a.appendChild(b);
            this.element_ = b;
            this.arcScaleX_ = 1;
            this.arcScaleY_ = 1;
            this.lineScale_ = 1
        }
        var X = S.prototype;
        X.clearRect = function () {
            this.element_.innerHTML = ""
        };
        X.beginPath = function () {
            this.currentPath_ = []
        };
        X.moveTo = function (b, c) {
            var a = this.getCoords_(b, c);
            this.currentPath_.push({
                type: "moveTo",
                x: a.x,
                y: a.y
            });
            this.currentX_ = a.x;
            this.currentY_ = a.y
        };
        X.lineTo = function (b, c) {
            var a = this.getCoords_(b, c);
            this.currentPath_.push({
                type: "lineTo",
                x: a.x,
                y: a.y
            });
            this.currentX_ = a.x;
            this.currentY_ = a.y
        };
        X.bezierCurveTo = function (a, b, d, e, f, h) {
            var c = this.getCoords_(f, h);
            var g = this.getCoords_(a, b);
            var k = this.getCoords_(d, e);
            U(this, g, k, c)
        };

        function U(c, d, a, b) {
            c.currentPath_.push({
                type: "bezierCurveTo",
                cp1x: d.x,
                cp1y: d.y,
                cp2x: a.x,
                cp2y: a.y,
                x: b.x,
                y: b.y
            });
            c.currentX_ = b.x;
            c.currentY_ = b.y
        }
        X.quadraticCurveTo = function (c, a, e, g) {
            var d = this.getCoords_(c, a);
            var f = this.getCoords_(e, g);
            var b = {
                x: this.currentX_ + 2 / 3 * (d.x - this.currentX_),
                y: this.currentY_ + 2 / 3 * (d.y - this.currentY_)
            };
            var h = {
                x: b.x + (f.x - this.currentX_) / 3,
                y: b.y + (f.y - this.currentY_) / 3
            };
            U(this, b, h, f)
        };
        X.arc = function (h, l, k, p, b, a) {
            k *= ag;
            var d = a ? "at" : "wa";
            var g = h + M(p) * k - V;
            var e = l + N(p) * k - V;
            var c = h + M(b) * k - V;
            var f = l + N(b) * k - V;
            if (g == c && !a) {
                g += 0.125
            }
            var q = this.getCoords_(h, l);
            var n = this.getCoords_(g, e);
            var o = this.getCoords_(c, f);
            this.currentPath_.push({
                type: d,
                x: q.x,
                y: q.y,
                radius: k,
                xStart: n.x,
                yStart: n.y,
                xEnd: o.x,
                yEnd: o.y
            })
        };
        X.rect = function (a, b, c, d) {
            this.moveTo(a, b);
            this.lineTo(a + c, b);
            this.lineTo(a + c, b + d);
            this.lineTo(a, b + d);
            this.closePath()
        };
        X.strokeRect = function (a, b, d, e) {
            var c = this.currentPath_;
            this.beginPath();
            this.moveTo(a, b);
            this.lineTo(a + d, b);
            this.lineTo(a + d, b + e);
            this.lineTo(a, b + e);
            this.closePath();
            this.stroke();
            this.currentPath_ = c
        };
        X.fillRect = function (a, b, d, e) {
            var c = this.currentPath_;
            this.beginPath();
            this.moveTo(a, b);
            this.lineTo(a + d, b);
            this.lineTo(a + d, b + e);
            this.lineTo(a, b + e);
            this.closePath();
            this.fill();
            this.currentPath_ = c
        };
        X.createLinearGradient = function (b, e, d, a) {
            var c = new T("gradient");
            c.x0_ = b;
            c.y0_ = e;
            c.x1_ = d;
            c.y1_ = a;
            return c
        };
        X.createRadialGradient = function (g, d, a, c, f, e) {
            var b = new T("gradientradial");
            b.x0_ = g;
            b.y0_ = d;
            b.r0_ = a;
            b.x1_ = c;
            b.y1_ = f;
            b.r1_ = e;
            return b
        };
        X.drawImage = function (f, w) {
            var p, r, n, B, h, l, d, z;
            var o = f.runtimeStyle.width;
            var g = f.runtimeStyle.height;
            f.runtimeStyle.width = "auto";
            f.runtimeStyle.height = "auto";
            var q = f.width;
            var a = f.height;
            f.runtimeStyle.width = o;
            f.runtimeStyle.height = g;
            if (arguments.length == 3) {
                p = arguments[1];
                r = arguments[2];
                h = l = 0;
                d = n = q;
                z = B = a
            } else {
                if (arguments.length == 5) {
                    p = arguments[1];
                    r = arguments[2];
                    n = arguments[3];
                    B = arguments[4];
                    h = l = 0;
                    d = q;
                    z = a
                } else {
                    if (arguments.length == 9) {
                        h = arguments[1];
                        l = arguments[2];
                        d = arguments[3];
                        z = arguments[4];
                        p = arguments[5];
                        r = arguments[6];
                        n = arguments[7];
                        B = arguments[8]
                    } else {
                        throw Error("Invalid number of arguments")
                    }
                }
            }
            var A = this.getCoords_(p, r);
            var v = d / 2;
            var x = z / 2;
            var C = [];
            var y = 10;
            var t = 10;
            C.push(" <g_vml_:group", ' coordsize="', ag * y, ",", ag * t, '"', ' coordorigin="0,0"', ' style="width:', y, "px;height:", t, "px;position:absolute;");
            if (this.m_[0][0] != 1 || this.m_[0][1]) {
                var u = [];
                u.push("M11=", this.m_[0][0], ",", "M12=", this.m_[1][0], ",", "M21=", this.m_[0][1], ",", "M22=", this.m_[1][1], ",", "Dx=", H(A.x / ag), ",", "Dy=", H(A.y / ag), "");
                var b = A;
                var c = this.getCoords_(p + n, r);
                var e = this.getCoords_(p, r + B);
                var k = this.getCoords_(p + n, r + B);
                b.x = I.max(b.x, c.x, e.x, k.x);
                b.y = I.max(b.y, c.y, e.y, k.y);
                C.push("padding:0 ", H(b.x / ag), "px ", H(b.y / ag), "px 0;filter:progid:DXImageTransform.Microsoft.Matrix(", u.join(""), ", sizingmethod='clip');")
            } else {
                C.push("top:", H(A.y / ag), "px;left:", H(A.x / ag), "px;")
            }
            C.push(' ">', '<g_vml_:image src="', f.src, '"', ' style="width:', ag * n, "px;", " height:", ag * B, 'px;"', ' cropleft="', h / q, '"', ' croptop="', l / a, '"', ' cropright="', (q - h - d) / q, '"', ' cropbottom="', (a - l - z) / a, '"', " />", "</g_vml_:group>");
            this.element_.insertAdjacentHTML("BeforeEnd", C.join(""))
        };
        X.stroke = function (ak) {
            var y = [];
            var w = false;
            var l = ae(ak ? this.fillStyle : this.strokeStyle);
            var ao = l.color;
            var x = l.alpha * this.globalAlpha;
            var E = 10;
            var r = 10;
            y.push("<g_vml_:shape", ' filled="', !! ak, '"', ' style="position:absolute;width:', E, "px;height:", r, 'px;"', ' coordorigin="0 0" coordsize="', ag * E, " ", ag * r, '"', ' stroked="', !ak, '"', ' path="');
            var u = false;
            var o = {
                x: null,
                y: null
            };
            var b = {
                x: null,
                y: null
            };
            for (var z = 0; z < this.currentPath_.length; z++) {
                var B = this.currentPath_[z];
                var q;
                switch (B.type) {
                case "moveTo":
                    q = B;
                    y.push(" m ", H(B.x), ",", H(B.y));
                    break;
                case "lineTo":
                    y.push(" l ", H(B.x), ",", H(B.y));
                    break;
                case "close":
                    y.push(" x ");
                    B = null;
                    break;
                case "bezierCurveTo":
                    y.push(" c ", H(B.cp1x), ",", H(B.cp1y), ",", H(B.cp2x), ",", H(B.cp2y), ",", H(B.x), ",", H(B.y));
                    break;
                case "at":
                case "wa":
                    y.push(" ", B.type, " ", H(B.x - this.arcScaleX_ * B.radius), ",", H(B.y - this.arcScaleY_ * B.radius), " ", H(B.x + this.arcScaleX_ * B.radius), ",", H(B.y + this.arcScaleY_ * B.radius), " ", H(B.xStart), ",", H(B.yStart), " ", H(B.xEnd), ",", H(B.yEnd));
                    break
                }
                if (B) {
                    if (o.x == null || B.x < o.x) {
                        o.x = B.x
                    }
                    if (b.x == null || B.x > b.x) {
                        b.x = B.x
                    }
                    if (o.y == null || B.y < o.y) {
                        o.y = B.y
                    }
                    if (b.y == null || B.y > b.y) {
                        b.y = B.y
                    }
                }
            }
            y.push(' ">');
            if (!ak) {
                var c = this.lineScale_ * this.lineWidth;
                if (c < 1) {
                    x *= c
                }
                y.push("<g_vml_:stroke", ' opacity="', x, '"', ' joinstyle="', this.lineJoin, '"', ' miterlimit="', this.miterLimit, '"', ' endcap="', L(this.lineCap), '"', ' weight="', c, 'px"', ' color="', ao, '" />')
            } else {
                if (typeof this.fillStyle == "object") {
                    var p = this.fillStyle;
                    var e = 0;
                    var D = {
                        x: 0,
                        y: 0
                    };
                    var an = 0;
                    var h = 1;
                    if (p.type_ == "gradient") {
                        var k = p.x0_ / this.arcScaleX_;
                        var ar = p.y0_ / this.arcScaleY_;
                        var n = p.x1_ / this.arcScaleX_;
                        var g = p.y1_ / this.arcScaleY_;
                        var t = this.getCoords_(k, ar);
                        var v = this.getCoords_(n, g);
                        var A = v.x - t.x;
                        var C = v.y - t.y;
                        e = Math.atan2(A, C) * 180 / Math.PI;
                        if (e < 0) {
                            e += 360
                        }
                        if (e < 0.000001) {
                            e = 0
                        }
                    } else {
                        var t = this.getCoords_(p.x0_, p.y0_);
                        var at = b.x - o.x;
                        var aj = b.y - o.y;
                        D = {
                            x: (t.x - o.x) / at,
                            y: (t.y - o.y) / aj
                        };
                        at /= this.arcScaleX_ * ag;
                        aj /= this.arcScaleY_ * ag;
                        var F = I.max(at, aj);
                        an = 2 * p.r0_ / F;
                        h = 2 * p.r1_ / F - an
                    }
                    var ap = p.colors_;
                    ap.sort(function (au, ah) {
                        return au.offset - ah.offset
                    });
                    var d = ap.length;
                    var aq = ap[0].color;
                    var a = ap[d - 1].color;
                    var al = ap[0].alpha * this.globalAlpha;
                    var am = ap[d - 1].alpha * this.globalAlpha;
                    var ai = [];
                    for (var z = 0; z < d; z++) {
                        var f = ap[z];
                        ai.push(f.offset * h + an + " " + f.color)
                    }
                    y.push('<g_vml_:fill type="', p.type_, '"', ' method="none" focus="100%"', ' color="', aq, '"', ' color2="', a, '"', ' colors="', ai.join(","), '"', ' opacity="', am, '"', ' g_o_:opacity2="', al, '"', ' angle="', e, '"', ' focusposition="', D.x, ",", D.y, '" />')
                } else {
                    y.push('<g_vml_:fill color="', ao, '" opacity="', x, '" />')
                }
            }
            y.push("</g_vml_:shape>");
            this.element_.insertAdjacentHTML("beforeEnd", y.join(""))
        };
        X.fill = function () {
            this.stroke(true)
        };
        X.closePath = function () {
            this.currentPath_.push({
                type: "close"
            })
        };
        X.getCoords_ = function (c, a) {
            var b = this.m_;
            return {
                x: ag * (c * b[0][0] + a * b[1][0] + b[2][0]) - V,
                y: ag * (c * b[0][1] + a * b[1][1] + b[2][1]) - V
            }
        };
        X.save = function () {
            var a = {};
            G(this, a);
            this.aStack_.push(a);
            this.mStack_.push(this.m_);
            this.m_ = ad(P(), this.m_)
        };
        X.restore = function () {
            G(this.aStack_.pop(), this);
            this.m_ = this.mStack_.pop()
        };

        function aa(b) {
            for (var a = 0; a < 3; a++) {
                for (var c = 0; c < 2; c++) {
                    if (!isFinite(b[a][c]) || isNaN(b[a][c])) {
                        return false
                    }
                }
            }
            return true
        }

        function R(a, c, d) {
            if (!aa(c)) {
                return
            }
            a.m_ = c;
            if (d) {
                var b = c[0][0] * c[1][1] - c[0][1] * c[1][0];
                a.lineScale_ = O(W(b))
            }
        }
        X.translate = function (a, b) {
            var c = [
                [1, 0, 0],
                [0, 1, 0],
                [a, b, 1]
            ];
            R(this, ad(c, this.m_), false)
        };
        X.rotate = function (b) {
            var d = M(b);
            var a = N(b);
            var c = [
                [d, a, 0],
                [-a, d, 0],
                [0, 0, 1]
            ];
            R(this, ad(c, this.m_), false)
        };
        X.scale = function (a, b) {
            this.arcScaleX_ *= a;
            this.arcScaleY_ *= b;
            var c = [
                [a, 0, 0],
                [0, b, 0],
                [0, 0, 1]
            ];
            R(this, ad(c, this.m_), true)
        };
        X.transform = function (f, g, b, d, c, e) {
            var a = [
                [f, g, 0],
                [b, d, 0],
                [c, e, 1]
            ];
            R(this, ad(a, this.m_), true)
        };
        X.setTransform = function (d, f, a, b, g, c) {
            var e = [
                [d, f, 0],
                [a, b, 0],
                [g, c, 1]
            ];
            R(this, e, true)
        };
        X.clip = function () {};
        X.arcTo = function () {};
        X.createPattern = function () {
            return new ab
        };

        function T(a) {
            this.type_ = a;
            this.x0_ = 0;
            this.y0_ = 0;
            this.r0_ = 0;
            this.x1_ = 0;
            this.y1_ = 0;
            this.r1_ = 0;
            this.colors_ = []
        }
        T.prototype.addColorStop = function (a, b) {
            b = ae(b);
            this.colors_.push({
                offset: a,
                color: b.color,
                alpha: b.alpha
            })
        };

        function ab() {}
        G_vmlCanvasManager = Y;
        CanvasRenderingContext2D = S;
        CanvasGradient = T;
        CanvasPattern = ab
    })()
}(function (b) {
    b.fn.hoverIntent = function (o, p) {
        var g = {
            sensitivity: 7,
            interval: 100,
            timeout: 0
        };
        g = b.extend(g, p ? {
            over: o,
            out: p
        } : o);
        var a, f, r, u;
        var t = function (c) {
            a = c.pageX;
            f = c.pageY
        };
        var v = function (c, d) {
            d.hoverIntent_t = clearTimeout(d.hoverIntent_t);
            if ((Math.abs(r - a) + Math.abs(u - f)) < g.sensitivity) {
                b(d).unbind("mousemove", t);
                d.hoverIntent_s = 1;
                return g.over.apply(d, [c])
            } else {
                r = a;
                u = f;
                d.hoverIntent_t = setTimeout(function () {
                    v(c, d)
                }, g.interval)
            }
        };
        var q = function (c, d) {
            d.hoverIntent_t = clearTimeout(d.hoverIntent_t);
            d.hoverIntent_s = 0;
            return g.out.apply(d, [c])
        };
        var w = function (e) {
            var c = jQuery.extend({}, e);
            var d = this;
            if (d.hoverIntent_t) {
                d.hoverIntent_t = clearTimeout(d.hoverIntent_t)
            }
            if (e.type == "mouseenter") {
                r = c.pageX;
                u = c.pageY;
                b(d).bind("mousemove", t);
                if (d.hoverIntent_s != 1) {
                    d.hoverIntent_t = setTimeout(function () {
                        v(c, d)
                    }, g.interval)
                }
            } else {
                b(d).unbind("mousemove", t);
                if (d.hoverIntent_s == 1) {
                    d.hoverIntent_t = setTimeout(function () {
                        q(c, d)
                    }, g.timeout)
                }
            }
        };
        return this.bind("mouseenter", w).bind("mouseleave", w)
    }
})(jQuery);
var dialog_Culture = {
    btn_ok: "确定",
    btn_clear: "清除",
    btn_close: "关闭",
    dialog_btn_text: "选择/修改",
    dialog_max_select: "最多只能选择{0}项",
    dialog_min_select: "至少选择一项！",
    dialog_required: "* 请选中一项！",
    dialog_Language_SL: "熟练程度",
    dialog_Language_Speak: "口语",
    dialog_Language_ReadWrite: "读写",
    dialog_Language_LG: "证书"
};
(function (R, U) {
    var G = R.fn.domManip,
        S = "_tmplitem",
        F = /^[^<]*(<[\w\W]+>)[^>]*$|\{\{\! /,
        K = {}, V = {}, B, C = {
            key: 0,
            data: {}
        }, D = 0,
        J = 0,
        T = [];

    function P(e, a, c, b) {
        var d = {
            data: b || (b === 0 || b === false) ? b : (a ? a.data : {}),
            _wrap: a ? a._wrap : null,
            tmpl: null,
            parent: a || null,
            nodes: [],
            calls: X,
            nest: Y,
            wrap: M,
            html: I,
            update: A
        };
        if (e) {
            R.extend(d, e, {
                nodes: [],
                parent: a
            })
        }
        if (c) {
            d.tmpl = c;
            d._ctnt = d._ctnt || d.tmpl(R, d);
            d.key = ++D;
            (T.length ? V : K)[D] = d
        }
        return d
    }
    R.each({
        appendTo: "append",
        prependTo: "prepend",
        insertBefore: "before",
        insertAfter: "after",
        replaceAll: "replaceWith"
    }, function (a, b) {
        R.fn[a] = function (k) {
            var g = [],
                d = R(k),
                h, f, j, c, e = this.length === 1 && this[0].parentNode;
            B = K || {};
            if (e && e.nodeType === 11 && e.childNodes.length === 1 && d.length === 1) {
                d[b](this[0]);
                g = this
            } else {
                for (f = 0, j = d.length; f < j; f++) {
                    J = f;
                    h = (f > 0 ? this.clone(true) : this).get();
                    R(d[f])[b](h);
                    g = g.concat(h)
                }
                J = 0;
                g = this.pushStack(g, a, d.selector)
            }
            c = B;
            B = null;
            R.tmpl.complete(c);
            return g
        }
    });
    R.fn.extend({
        tmpl: function (b, c, a) {
            return R.tmpl(this[0], b, c, a)
        },
        tmplItem: function () {
            return R.tmplItem(this[0])
        },
        template: function (a) {
            return R.template(a, this[0])
        },
        domManip: function (j, f, g, e) {
            if (j[0] && R.isArray(j[0])) {
                var c = R.makeArray(arguments),
                    d = j[0],
                    h = d.length,
                    b = 0,
                    a;
                while (b < h && !(a = R.data(d[b++], "tmplItem"))) {}
                if (a && J) {
                    c[2] = function (k) {
                        R.tmpl.afterManip(this, k, g)
                    }
                }
                G.apply(this, c)
            } else {
                G.apply(this, arguments)
            }
            J = 0;
            if (!B) {
                R.tmpl.complete(K)
            }
            return this
        }
    });
    R.extend({
        tmpl: function (e, b, c, f) {
            var d, a = !f;
            if (a) {
                f = C;
                e = R.template[e] || R.template(null, e);
                V = {}
            } else {
                if (!e) {
                    e = f.tmpl;
                    K[f.key] = f;
                    f.nodes = [];
                    if (f.wrapped) {
                        H(f, f.wrapped)
                    }
                    return R(N(f, null, f.tmpl(R, f)))
                }
            } if (!e) {
                return []
            }
            if (typeof b === "function") {
                b = b.call(f || {})
            }
            if (c && c.wrapped) {
                H(c, c.wrapped)
            }
            d = R.isArray(b) ? R.map(b, function (g) {
                return g ? P(c, f, e, g) : null
            }) : [P(c, f, e, b)];
            return a ? R(N(f, null, d)) : d
        },
        tmplItem: function (b) {
            var a;
            if (b instanceof R) {
                b = b[0]
            }
            while (b && b.nodeType === 1 && !(a = R.data(b, "tmplItem")) && (b = b.parentNode)) {}
            return a || C
        },
        template: function (b, a) {
            if (a) {
                if (typeof a === "string") {
                    a = O(a)
                } else {
                    if (a instanceof R) {
                        a = a[0] || {}
                    }
                } if (a.nodeType) {
                    a = R.data(a, "tmpl") || R.data(a, "tmpl", O(a.innerHTML))
                }
                return typeof b === "string" ? (R.template[b] = a) : a
            }
            return b ? (typeof b !== "string" ? R.template(null, b) : (R.template[b] || R.template(null, F.test(b) ? b : R(b)))) : null
        },
        encode: function (a) {
            return ("" + a).split("<").join("&lt;").split(">").join("&gt;").split('"').join("&#34;").split("'").join("&#39;")
        }
    });
    R.extend(R.tmpl, {
        tag: {
            tmpl: {
                _default: {
                    $2: "null"
                },
                open: "if($notnull_1){__=__.concat($item.nest($1,$2));}"
            },
            wrap: {
                _default: {
                    $2: "null"
                },
                open: "$item.calls(__,$1,$2);__=[];",
                close: "call=$item.calls();__=call._.concat($item.wrap(call,__));"
            },
            each: {
                _default: {
                    $2: "$index, $value"
                },
                open: "if($notnull_1){$.each($1a,function($2){with(this){",
                close: "}});}"
            },
            "if": {
                open: "if(($notnull_1) && $1a){",
                close: "}"
            },
            "else": {
                _default: {
                    $1: "true"
                },
                open: "}else if(($notnull_1) && $1a){"
            },
            html: {
                open: "if($notnull_1){__.push($1a);}"
            },
            "=": {
                _default: {
                    $1: "$data"
                },
                open: "if($notnull_1){__.push($.encode($1a));}"
            },
            "!": {
                open: ""
            }
        },
        complete: function (a) {
            K = {}
        },
        afterManip: function E(c, a, b) {
            var d = a.nodeType === 11 ? R.makeArray(a.childNodes) : a.nodeType === 1 ? [a] : [];
            b.call(c, a);
            L(d);
            J++
        }
    });

    function N(a, b, d) {
        var c, e = d ? R.map(d, function (f) {
                return (typeof f === "string") ? (a.key ? f.replace(/(<\w+)(?=[\s>])(?![^>]*_tmplitem)([^>]*)/g, "$1 " + S + '="' + a.key + '" $2') : f) : N(f, a, f._ctnt)
            }) : a;
        if (b) {
            return e
        }
        e = e.join("");
        e.replace(/^\s*([^<\s][^<]*)?(<[\w\W]+>)([^>]*[^>\s])?\s*$/, function (h, g, j, f) {
            c = R(j).get();
            L(c);
            if (g) {
                c = Z(g).concat(c)
            }
            if (f) {
                c = c.concat(Z(f))
            }
        });
        return c ? c : Z(e)
    }

    function Z(b) {
        var a = document.createElement("div");
        a.innerHTML = b;
        return R.makeArray(a.childNodes)
    }

    function O(a) {
        return new Function("jQuery", "$item", "var $=jQuery,call,__=[],$data=$item.data;with($data){__.push('" + R.trim(a).replace(/([\\'])/g, "\\$1").replace(/[\r\t\n]/g, " ").replace(/\$\{([^\}]*)\}/g, "{{= $1}}").replace(/\{\{(\/?)(\w+|.)(?:\(((?:[^\}]|\}(?!\}))*?)?\))?(?:\s+(.*?)?)?(\(((?:[^\}]|\}(?!\}))*?)\))?\s*\}\}/g, function (h, c, k, b, m, g, l) {
            var e = R.tmpl.tag[k],
                d, j, f;
            if (!e) {
                throw "Unknown template tag: " + k
            }
            d = e._default || [];
            if (g && !/\w$/.test(m)) {
                m += g;
                g = ""
            }
            if (m) {
                m = Q(m);
                l = l ? ("," + Q(l) + ")") : (g ? ")" : "");
                j = g ? (m.indexOf(".") > -1 ? m + Q(g) : ("(" + m + ").call($item" + l)) : m;
                f = g ? j : "(typeof(" + m + ")==='function'?(" + m + ").call($item):(" + m + "))"
            } else {
                f = j = d.$1 || "null"
            }
            b = Q(b);
            return "');" + e[c ? "close" : "open"].split("$notnull_1").join(m ? "typeof(" + m + ")!=='undefined' && (" + m + ")!=null" : "true").split("$1a").join(f).split("$1").join(j).split("$2").join(b || d.$2 || "") + "__.push('"
        }) + "');}return __;")
    }

    function H(b, a) {
        b._wrap = N(b, true, R.isArray(a) ? a : [F.test(a) ? a : R(a).html()]).join("")
    }

    function Q(a) {
        return a ? a.replace(/\\'/g, "'").replace(/\\\\/g, "\\") : null
    }

    function W(a) {
        var b = document.createElement("div");
        b.appendChild(a.cloneNode(true));
        return b.innerHTML
    }

    function L(g) {
        var e = "_" + J,
            c, d, j = {}, h, a, b;
        for (h = 0, a = g.length; h < a; h++) {
            if ((c = g[h]).nodeType !== 1) {
                continue
            }
            d = c.getElementsByTagName("*");
            for (b = d.length - 1; b >= 0; b--) {
                f(d[b])
            }
            f(c)
        }

        function f(o) {
            var k, p = o,
                q, m, l;
            if ((l = o.getAttribute(S))) {
                while (p.parentNode && (p = p.parentNode).nodeType === 1 && !(k = p.getAttribute(S))) {}
                if (k !== l) {
                    p = p.parentNode ? (p.nodeType === 11 ? 0 : (p.getAttribute(S) || 0)) : 0;
                    if (!(m = K[l])) {
                        m = V[l];
                        m = P(m, K[p] || V[p]);
                        m.key = ++D;
                        K[D] = m
                    }
                    if (J) {
                        n(l)
                    }
                }
                o.removeAttribute(S)
            } else {
                if (J && (m = R.data(o, "tmplItem"))) {
                    n(m.key);
                    K[m.key] = m;
                    p = R.data(o.parentNode, "tmplItem");
                    p = p ? p.key : 0
                }
            } if (m) {
                q = m;
                while (q && q.key != p) {
                    q.nodes.push(o);
                    q = q.parent
                }
                delete m._ctnt;
                delete m._wrap;
                R.data(o, "tmplItem", m)
            }

            function n(r) {
                r = r + e;
                m = j[r] = (j[r] || P(m, K[m.parent.key + e] || m.parent))
            }
        }
    }

    function X(c, a, b, d) {
        if (!c) {
            return T.pop()
        }
        T.push({
            _: c,
            tmpl: a,
            item: this,
            data: b,
            options: d
        })
    }

    function Y(a, b, c) {
        return R.tmpl(R.template(a), b, c, this)
    }

    function M(b, a) {
        var c = b.options || {};
        c.wrapped = a;
        return R.tmpl(R.template(b.tmpl), b.data, c, b.item)
    }

    function I(c, b) {
        var a = this._wrap;
        return R.map(R(R.isArray(a) ? a.join("") : a).filter(c || "*"), function (d) {
            return b ? d.innerText || d.textContent : d.outerHTML || W(d)
        })
    }

    function A() {
        var a = this.nodes;
        R.tmpl(null, null, null, this).insertBefore(a[0]);
        R(a).remove()
    }
})(jQuery);