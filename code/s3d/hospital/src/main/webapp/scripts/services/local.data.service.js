(function () {
    'use strict';
    angular.module('cms')
        .service('localDataService', localDataService);

    localDataService.$inject = [];

    function localDataService () {
        var _this = this;
        var _virtualItem = null;

        this.getVirtualItem = getVirtualItem;
        this.setVirtualItem = setVirtualItem;
        this.get = get;
        this.set = set;
        this.getSettings = getSettings;
        this.getNode = getNode;

        /**
         * Get virtual item
         * @returns {*}
         */
        function getVirtualItem () {
            return _virtualItem;
        }

        /**
         * Set vurtyak item
         * @param data
         */
        function setVirtualItem (data) {
            _virtualItem = data;
        }

        /**
         * Get data from virtual item by key
         * @param key
         * @param isClone
         * @returns {*}
         */
        function get (key, isClone) {
            if (isClone) {
                return _.cloneDeep(_virtualItem[key]);
            } else {
                return _virtualItem[key];
            }
        }

        /**
         * Set data to virtual item by key
         * @param key
         * @param value
         */
        function set (key, value) {
            var obj = {};
            obj[key] = value;
            _.merge(_virtualItem, obj, function (a, b) {
                if (_.isArray(a)) {
                    return b;
                }
            });
        }

        /**
         * Get settings data
         * @returns {*}
         */
        function getSettings () {
            if (_.isEmpty(_virtualItem.settings)) {
                return {
                    type: null,
                    name: null,
                    description: null,
                    locationKey: null,
                    enableScroll: null,
                    boothSize: null,
                    languages: null,
                    entitlements: null
                };
            } else {
                return _virtualItem.settings;
            }
        }

        /**
         * Get node by id
         * @param nodeId
         * @returns {*}
         */
        function getNode (nodeId, isClone) {
            var node;
            if (_virtualItem && _virtualItem.template && _virtualItem.template.nodes) {
                node = _.find(_virtualItem.template.nodes, function(node){
                    return node.id == nodeId;
                });
            }
            if (isClone) {
                return _.cloneDeep(node);
            }
            return node;
        }

    }



})();